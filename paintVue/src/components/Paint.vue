<template>
  <div class="container">
<v-dialog width="400" class="saving" v-model="savdialog" transition="dialog-top-transition">
<v-card variant="outlined">
<v-card-title><h1>save</h1></v-card-title>
<v-btn :style="{ backgroundColor: savjason === true ? '#b300b3' : 'initial', color: savjason === true ? '#FFFFFF' : 'initial' }" @click="savejason()">json</v-btn>
<div style="height:5px;"></div>
<v-btn :style="{ backgroundColor: savxml === true ? '#b300b3' : 'initial', color: savxml === true ? '#FFFFFF' : 'initial' }" @click="savexml()">xml</v-btn>
<v-card-actions >
  <v-btn  variant="outlined" @click="submity() ">OK</v-btn>
</v-card-actions>
</v-card>
</v-dialog>
<v-dialog width="400" class="saving" v-model="pathdialog" transition="dialog-bottom-transition">
<v-card variant="outlined">
<v-card-title>path of saving</v-card-title>
<input type="text" placeholder="c:\\path" id="path" autofocus>
<v-card-actions >
  <v-btn  variant="outlined" @click="send()">save</v-btn>
</v-card-actions>
</v-card>
</v-dialog>
<v-dialog width="400" class="saving" v-model="loaddialog" transition="dialog-top-transition">
<v-card variant="outlined">
<v-card-title><h1>Open</h1></v-card-title>
<v-btn :style="{ backgroundColor: lodjason === true ? '#b300b3' : 'initial', color: lodjason === true ? '#FFFFFF' : 'initial' }" @click="loadjason()">json</v-btn>
<div style="height:5px;"></div>
<v-btn :style="{ backgroundColor: lodxml === true ? '#b300b3' : 'initial', color: lodxml === true ? '#FFFFFF' : 'initial' }" @click="loadxml()">xml</v-btn>
<v-card-actions >
  <v-btn  variant="outlined" @click="ok() ">OK</v-btn>
</v-card-actions>
</v-card>
</v-dialog>
<v-dialog width="400" class="saving" v-model="pathloaddialog" transition="dialog-bottom-transition">
<v-card variant="outlined">
<v-card-title>path of file</v-card-title>
<input type="text" placeholder="c:\\path" id="pathload" autofocus>
<v-card-actions >
  <v-btn  variant="outlined" @click="open()">open</v-btn>
</v-card-actions>
</v-card>
</v-dialog>

<div class="bord">
<v-stage :config="configKonva" ref="stage" @dblclick="draw" @click="handleClick"  @mousedown="handleStageMouseDown">
<v-layer>
<!-- drawing squares   -->
<v-rect
v-for="(square, index) in squares"
:key="index"
:config="{
 x: square.x,
y: square.y,
width: square.width,
height: square.height,
fill: square.fill, // Use the selected fill color
stroke: square.stroke, // Use the selected edge color
strokeWidth: 2 ,
draggable:true,
id:square.id,
rotation:square.rotation,
scaleX:square.scaleX,
scaleY:square.scaleY

}"
@transformend="handleTransformEnd"
@click="shapeClicked('square', index)"
@dragend="newpo('square', index, $event)"   
>

</v-rect>
<!-- drawing rectangles -->
<v-rect
v-for="(rect, index) in rectangles"
:key="index"
:config="{ 
x:  rect.x,
y: rect.y,
width: rect.width,
height: rect.height,
fill: rect.fill, // Use the selected fill color
stroke: rect.stroke, // Use the selected edge color
strokeWidth: 2 ,
draggable:true,
id:rect.id,
rotation:rect.rotation,
scaleX:rect.scaleX,
scaleY:rect.scaleY
 
}"
@transformend="handleTransformEnd"
@click="shapeClicked('rect', index) "
@dragend="newpo('rect', index, $event)"   


></v-rect>

<!-- drawing circles -->
<v-circle
v-for="(circle, index) in circles"
:key="index"
:config="{
x: circle.x,
y: circle.y,
radius:circle.radius,
fill:circle.fill,
stroke:circle.stroke,
strokeWidth: 2,
draggable:true,
id:circle.id,
 rotation:circle.rotation,
scaleX:circle.scaleX,
scaleY:circle.scaleY
}"
@transformend="handleTransformEnd"
@click="shapeClicked('circle', index)"
@dragend="newpo('circle', index, $event)"     >

</v-circle>

<!-- drawing ellipses -->
<v-ellipse
v-for="(ellipse, index) in ellipses"
:key="index"
:config="{
x: ellipse.x,
y: ellipse.y,
radiusX:ellipse.radiusX,
radiusY:ellipse.radiusY,
fill: ellipse.fill, // Use the selected fill color
stroke: ellipse.stroke, // Use the selected edge color
strokeWidth: 2,
draggable:true,
id:ellipse.id,
 rotation:ellipse.rotation,
scaleX:ellipse.scaleX,
scaleY:ellipse.scaleY
}"
@transformend="handleTransformEnd"
@click="shapeClicked('ellipse', index)"
@dragend="newpo('ellipse', index, $event)"   

>

</v-ellipse>
<!-- drawing star -->

<v-star
v-for="(star, index) in stars"
:key="index"
:config="{
x: star.x,
y: star.y,
innerRadius:star.innerRadius,
outerRadius:star.outerRadius,
numPoints:star.numPoints,
fill: star.fill, // Use the selected fill color
stroke: star.stroke, // Use the selected edge color
strokeWidth: 2,
draggable:true,
id:star.id,
 rotation:star.rotation,
scaleX:star.scaleX,
scaleY:star.scaleY
}"
@transformend="handleTransformEnd"
@click="shapeClicked('star', index)"
@dragend="newpo('star', index, $event)"   

>

</v-star>
<!-- drawing line segment -->

<v-line
v-for="(line, index) in lines"
:key="index"
:config="{
x : line.x,
y : line.y,
points:line.points,
stroke: line.stroke,
strokeWidth: 4,
draggable:true,
id:line.id,
 rotation:line.rotation,
scaleX:line.scaleX,
scaleY:line.scaleY
}"
@transformend="handleTransformEnd"
@click="shapeClicked('line', index)"
@dragend="newpo('line', index, $event)"   
>

</v-line>
<!-- Drawing Triangles -->
<v-regular-polygon
v-for="(triangle, index) in triangles"
:key="index"
:config="{
x: triangle.x,
y: triangle.y,
sides:3,
radius:triangle.radius,
fill: triangle.fill, 
stroke: triangle.stroke, 
strokeWidth: 2,
draggable:true,
id:triangle.id,
 rotation:triangle.rotation,
scaleX:triangle.scaleX,
scaleY:triangle.scaleY
}"
@transformend="handleTransformEnd"
@click="shapeClicked('triangle', index)"
@dragend="newpo('triangle', index, $event)"   
>

</v-regular-polygon>
<!-- brush -->
<v-line
v-for="(line, index) in brus"
:key="index"
:config="{
points:line.points,
stroke: line.stroke,
strokeWidth: 4,
draggable:false,
}"
>

</v-line>

<v-transformer ref="transformer" />
</v-layer>
</v-stage>
</div>

<div class="left-bar">
<button title="Open" @click="laod()" class="custom-btn"><i class="fa-solid fa-folder-open"></i></button>
<button title="Save" @click="save()" class="custom-btn"><i class="fa-solid fa-floppy-disk"></i></button>
<hr>
<div class="palette">
  <color-picker v-model:gradientColor="gradientColor" v-model:pureColor="pureColor" class="color-picker" />
</div>
<button title="Fill" @click="fill()" class="custom-btn"><i class="fa-solid fa-fill-drip"></i></button>
<button title="Border" @click="edge()" class="custom-btn"><i class="fa-solid fa-paintbrush"></i></button>
<button title="Copy" @click="copy()" class="custom-btn"><i class="fa-solid fa-copy"></i></button>
<button title="Undo" @click="undo()" class="custom-btn"><i class="fa-solid fa-arrow-rotate-left"></i></button>
<button title="Redo" @click="Redo()" class="custom-btn"><i class="fa-solid fa-rotate-right"></i></button>
<hr>
<button title="Square" @click="square()" class="custom-btn">
<svg width="24" height="24" xmlns="http://www.w3.org/2000/svg" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
  <rect width="18" height="18" x="3" y="3"></rect> <!-- Square -->
</svg>
</button>
<button title="Rectangle" @click="rect()" class="custom-btn">
<svg width="24" height="12" xmlns="http://www.w3.org/2000/svg" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
  <rect width="18" height="10" x="3" y="1"></rect> <!-- Rectangle -->
</svg>
</button>
<button title="Circle" @click="circle()" class="custom-btn">
<svg width="24" height="24" xmlns="http://www.w3.org/2000/svg" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
  <circle cx="12" cy="12" r="10"></circle> <!-- Circle -->
</svg>
</button>
<button title="Triangle" @click="triangle()" class="custom-btn">
<svg width="24" height="24" xmlns="http://www.w3.org/2000/svg" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
  <polygon points="12 2 2 22 22 22"></polygon> <!-- Triangle -->
</svg>
</button>
<button title="Ellipse" @click="ellipse()" class="custom-btn">  
<svg width="24" height="24" xmlns="http://www.w3.org/2000/svg" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
  <ellipse cx="12" cy="12" rx="10" ry="6"></ellipse> <!-- Ellipse -->
</svg>
</button>
<button title="Star" @click="star()" class="custom-btn">
<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
  <polygon points="12 2 15.09 8 22 9.27 17 14 18.18 20 12 17.09 5.82 20 7 14 2 9.27 8 8 12"></polygon>
</svg>
</button>
<button title="Line" @click="line()" class="custom-btn">  
<svg width="24" height="24" xmlns="http://www.w3.org/2000/svg" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
  <line x1="2" y1="12" x2="22" y2="12"></line> <!-- Line -->
</svg>
</button>
<hr>

<button title="Delete" @click="del()" class="custom-btn"><i class="fa-solid fa-eraser"></i></button>
<button title="Clear" @click="clr()" class="custom-btn"><i class="fa-solid fa-trash"></i></button>

</div>
</div>
</template>

<script>
import { ref } from "vue";
import { ColorInputWithoutInstance } from "tinycolor2";

export default  {
  name: 'Paint-',
  data() {
    return {
      value: null,
      selectedColor: '',
      selectedColor2: '',
      selectedColor3: '',
      selectedColor4: '',
      selectedColor5: '',
      configKonva: {
          width: window.innerWidth,
          height: window.innerHeight,
      },
      pureColor: '#00000000',
      pureColor2: '#000000', // Selected edge color
      isdraw: false,
      rectangles:[],
      squares:[],
      lines:[],
      circles:[],
      ellipses:[],
      triangles:[],
      stars:[],
       polygons:[],
      rectangle:false,
      circ:false,
      ellips:false,
      lin:false,
      sqrt:false,
      tria:false,
      bru:false,
      str:false,
      poly:false,
      delete:false,
      cofill:false,
      coledge:false,
      currentShape:null,
      shapes:[],
      selectedshapeid: '',  //transform
        sav:false,
        path:"" ,
        shapeType: '',
      ord:null,
      modifysh:null,
      cop:false,
      co:null,
        savdialog:false,
        savjason:false,
        savxml:false,
        pathdialog:false,
        loaddialog:false,
        pathloaddialog:false,
        lodjason:false,
        lodxml:false,
        poldialog:false,
        length:200,
        un:0,
        re:0,
        shapeid:-1,
         brus:[]
    };
  },
  
  methods: {
    setup() {
      const pureColor = ref<ColorInputWithoutInstance>("red");
      return{pureColor}
    },
   handleClick() {
       this.cop=false;
      this.cofill=false;
      this.coledge=false; 
    },
newpo(type, index,e) {
  this.un++;
   var v=0;

  if (type === 'circle') {
    this.shapeType = "Circle"
       for(let i=0;i<this.shapes.length;i++)
        {
          if(this.shapes[i]!==null)
          {
                  if(this.shapes[i].id===this.circles[index].id)
                  {
                    v=i;
                    break;
                  }
          }
        
        }
          console.log(v);
    this.circles[index].x=e.target.x();
    this.circles[index].y=e.target.y();
    this.shapes[v].x=this.circles[index].x;
    this.shapes[v].y=this.circles[index].y;
    this.modifysh=this.shapes[v];
    this.ord=v;
    this.modify()
    console.log(this.shapes[v]);
    console.log(this.circles[index].x);
    console.log(this.circles[index].y);
    }
    if (type === 'rect') {
      this.shapeType = "Rectangle"
     for(let i=0;i<this.shapes.length;i++)
        {
          if(this.shapes[i]!==null)
          {
                  if(this.shapes[i].id===this.rectangles[index].id)
                  {
                    v=i;
                    break;
                  }
          }
        
        }
         console.log(v);
    this.rectangles[index].x=e.target.x();
    this.rectangles[index].y=e.target.y();
    this.shapes[v].x=this.rectangles[index].x;
    this.shapes[v].y=this.rectangles[index].y;
      this.modifysh=this.shapes[v];
    this.ord=v;
    this.modify()
    console.log(this.rectangles[index].x);
    console.log(this.rectangles[index].y);
    }
    if (type === 'ellipse') {
      this.shapeType = "Ellipse"
    for(let i=0;i<this.shapes.length;i++)
        {
          if(this.shapes[i]!==null)
          {
                  if(this.shapes[i].id===this.ellipses[index].id)
                  {
                    v=i;
                    break;
                  }
          }
        
        }
         console.log(v);
    this.ellipses[index].x=e.target.x();
    this.ellipses[index].y=e.target.y();
    this.shapes[v].x=this.ellipses[index].x;
    this.shapes[v].y=this.ellipses[index].y;
      this.modifysh=this.shapes[v];
    this.ord=v;
    this.modify()
    console.log(this.ellipses[index].x);
    console.log(this.ellipses[index].y);
    }
    if (type === 'star') {
      this.shapeType = "Star"
      for(let i=0;i<this.shapes.length;i++)
        {
          if(this.shapes[i]!==null)
          {
                  if(this.shapes[i].id===this.stars[index].id)
                  {
                    v=i;
                    break;
                  }
          }
        
        }
         console.log(v);
        
    this.stars[index].x=e.target.x();
    this.stars[index].y=e.target.y();
    this.shapes[v].x=this.stars[index].x;
    this.shapes[v].y=this.stars[index].y;
    this.modifysh=this.shapes[v];
    this.ord=v;
    this.modify()
    console.log(this.stars[index].x);
    console.log(this.stars[index].y);
    
  }
    if (type === 'line') {
      this.shapeType = "Line"
      for(let i=0;i<this.shapes.length;i++)
        {
          if(this.shapes[i]!==null)
          {
                  if(this.shapes[i].id===this.lines[index].id)
                  {
                    v=i;
                    break;
                  }
          }
        
        }
         console.log(v);
    this.lines[index].x=e.target.x();
    this.lines[index].y=e.target.y();
    this.shapes[v].x=this.lines[index].x;
    this.shapes[v].y=this.lines[index].y;
    this.modifysh=this.shapes[v];
    this.ord=v;
    this.modify()
    console.log(this.lines[index].x);
    console.log(this.lines[index].y);
    }
    if (type === 'square') {
      this.shapeType = "Square"
     for(let i=0;i<this.shapes.length;i++)
        {
          if(this.shapes[i]!==null)
          {
                  if(this.shapes[i].id===this.squares[index].id)
                  {
                    v=i;
                    break;
                  }
          }
        
        }
         console.log(v);
    this.squares[index].x=e.target.x();
    this.squares[index].y=e.target.y();
    this.shapes[v].x=this.squares[index].x;
    this.shapes[v].y=this.squares[index].y;
      this.modifysh=this.shapes[v];
    this.ord=v;
    this.modify()
    console.log(this.squares[index].x);
    console.log(this.squares[index].y);
    }
    if (type === 'triangle') {
      this.shapeType = "Triangle"
    
        for(let i=0;i<this.shapes.length;i++)
        {
          if(this.shapes[i]!==null)
          {
                  if(this.shapes[i].id===this.triangles[index].id)
                  {
                    v=i;
                    break;
                  }
          }
        
        }
         console.log(v);
    this.triangles[index].x=e.target.x();
    this.triangles[index].y=e.target.y();
    this.shapes[v].x=this.triangles[index].x;
    this.shapes[v].y=this.triangles[index].y;
    this.modifysh=this.shapes[v];
    this.ord=v;
    this.modify()
    console.log(this.triangles[index].x);
    console.log(this.triangles[index].y);
    }

    if (type === 'Polygon') {
      this.shapeType = "Polygon"
      for(let i=0;i<this.shapes.length;i++)
        {
          if(this.shapes[i]!==null)
          {
                  if(this.shapes[i].id===this.polygons[index].id)
                  {
                    v=i;
                    break;
                  }
          }
        
        }
         console.log(v);
    this.polygons[index].x=e.target.x();
    this.polygons[index].y=e.target.y();
    this.shapes[v].x=this.polygons[index].x;
    this.shapes[v].y=this.polygons[index].y;
    this.modifysh=this.shapes[v];
    this.ord=v;
    this.modify()
    console.log(this.polygons[index].x);
    console.log(this.polygons[index].y);
    }
    
    
  },
    rect(){
         this.rectangle=true;
       this.circ=false;
      this.ellips=false;
      this.lin=false;
      this.sqrt=false;
      this.tria=false;
      this.cofill=false;
      this.delete=false;
      this.coledge=false;
      this.bru=false;
      this.str=false;
      this.poly=false;
    },
    brush(){
           this.rectangle=false;
       this.circ=false;
      this.ellips=false;
      this.lin=false;
      this.sqrt=false;
      this.tria=false;
      this.cofill=false;
      this.delete=false;
      this.coledge=false;
      this.bru=true;
         this.str=false;
      this.poly=false;
    },
    ellipse()
    {
       this.rectangle=false;
       this.circ=false;
      this.ellips=true;
      this.lin=false;
      this.sqrt=false;
      this.tria=false;
      this.cofill=false;
      this.delete=false;
      this.coledge=false;
      this.bru=false;
         this.str=false;
      this.poly=false;
    }, 
    star()
    {
       this.rectangle=false;
       this.circ=false;
      this.ellips=false;
      this.str=true;
      this.lin=false;
      this.sqrt=false;
      this.tria=false;
      this.cofill=false;
      this.delete=false;
      this.coledge=false;
      this.bru=false;
      this.poly=false;
    }, 
    circle()
    {
         this.rectangle=false;
       this.circ=true;
      this.ellips=false;
      this.lin=false;
      this.sqrt=false;
      this.tria=false;
      this.cofill=false;
      this.delete=false;
      this.coledge=false;
      this.bru=false;
      this.str=false;
      this.poly=false;
    },
    line()
    {
           this.rectangle=false;
       this.circ=false;
      this.ellips=false;
      this.lin=true;
      this.sqrt=false;
      this.tria=false;
      this.cofill=false;
      this.delete=false;
      this.coledge=false;
      this.bru=false;
        this.str=false;
      this.poly=false;
    },
    square()
    {

          this.rectangle=false;
       this.circ=false;
      this.ellips=false;
      this.lin=false;
      this.sqrt=true;
      this.tria=false;
      this.cofill=false;
      this.delete=false;
      this.coledge=false;
      this.bru=false;
        this.str=false;
      this.poly=false;
    },
    triangle()
    {
          this.rectangle=false;
       this.circ=false;
      this.ellips=false;
      this.lin=false;
      this.sqrt=false;
      this.tria=true;
      this.cofill=false;
      this.delete=false;
      this.coledge=false;
      this.bru=false;
        this.str=false;
      this.poly=false;
    },
    fill(){

          this.rectangle=false;
       this.circ=false;
      this.ellips=false;
      this.lin=false;
      this.sqrt=false;
      this.tria=false;
      this.cofill=true;
      this.delete=false;
      this.coledge=false;
      this.bru=false;
        this.str=false;
      this.poly=false;

    },
    edge(){
        this.rectangle=false;
       this.circ=false;
      this.ellips=false;
      this.lin=false;
      this.sqrt=false;
      this.tria=false;
      this.cofill=false;
      this.delete=false;
      this.coledge=true;
      this.bru=false;
        this.str=false;
      this.poly=false;

    },
   polyg()
    {
      this.rectangle=false;
      this.circ=false;
      this.ellips=false;
      this.lin=false;
      this.sqrt=false;
      this.tria=false;
      this.poly=true;
      this.cofill=false;
      this.delete=false;
      this.coledge=false;
      this.str=false;
      this.bru=false;
    },



  async  clr()
    {
      this.circles=[];
      this.lines=[];
      this.squares=[];
      this.rectangles=[];
      this.triangles=[];
      this.ellipses=[];
      this.shapes=[];
      this.stars =[];
      this.polygons=[];
      this.un=0;
      this.re=0;
      this.shapeid=-1;
             await fetch('http://localhost:8080/clear', {
        method: 'GET',
      }).catch(error => {
        console.error('Fetch error:', error);
      });
    
    
    },
    copy()
    {
      this.cop=true;
    },

    async shapeClicked(type, index) {


    if(type==='Polygon')
     {
       this.shapeType = "Polygon"
        let v=0;
     for(let i=0;i<this.shapes.length;i++)
        {
           if(this.shapes[i]!==null)
          {
                  if(this.shapes[i].id===this.polygons[index].id)
                  {
                    v=i;
                    break;
                  }
          }
        
        }
         console.log(v);
        if(this.cop)
        {
          this.updateTransformer();
          this.un++;
          this.ord=v;
          console.log(this.shapes[v])
          await this.prototype();
          console.log(this.co)
          this.polygons.push({...this.co})
          this.shapes.push({...this.co})
          this.cop = false
          this.shapeid++
        }
        if(this.delete)
        {
         
           this.un++; 
              this.polygons.splice(index,1);
               this.modifysh=this.shapes[v];
                    this.ord=v;
                    this.modify2()
              this.delete=false;
              this.selectedid=-1;
               this.updateTransformer();
        }

       if (this.cofill) {
        this.un++;
        let   selectedFillColor = this.pureColor; // Store the selected fill color in a variable
        this.selectedColor2= selectedFillColor
        this.polygons[index].fill = selectedFillColor;
        this.shapes[v].fill=this.polygons[index].fill;       // Assign the selected fill color to the fill property of the shape object
        selectedFillColor=this.pureColor
        this.cofill = false;
        this.pureColor = '#ffffff'; // Reset the pureColor to a default value or another selected fill color
          this.modifysh=this.shapes[v];
             this.ord=v;
              this.modify()
                 }
             if(this.coledge){
              this.un++;
              let selectedEdgeColor = this.pureColor; // Use the selected edge color
          this.polygons[index].stroke = selectedEdgeColor; 
          this.shapes[v].stroke=this.polygons[index].stroke; // Assign the selected edge color to the stroke property of the shape object
          this.coledge = false;
          this.pureColor = '#ffffff'; // Reset the pureColor2 to a default value or another selected edge color
                 this.modifysh=this.shapes[v];
                  this.ord=v;
                 this.modify() 
       
          }
       
        
     }

     else if(type==='triangle')
     {
      this.shapeType = "Triangle"
         console.log(index);
        let v=0;
    for(let i=0;i<this.shapes.length;i++)
        {
          if(this.shapes[i]!==null)
          {
                  if(this.shapes[i].id===this.triangles[index].id)
                  {
                    v=i;
                    break;
                  }
          }
        
        }
          console.log(v);
        if(this.cop)
        {
          this.un++;
          this.ord=v;
          console.log(this.shapes[v])
          await this.prototype();
          console.log(this.co)
          this.triangles.push({...this.co})
          this.shapes.push({...this.co})
          this.cop = false
          this.shapeid++
        }
        if(this.delete)
        {
           this.un++; 
              this.triangles.splice(index,1);
               this.modifysh=this.shapes[v];
                    this.ord=v;
                    this.modify2()
              this.delete=false;
            
        }

       if (this.cofill) {
        this.un++;
        let   selectedFillColor = this.pureColor; // Store the selected fill color in a variable
        this.selectedColor2= selectedFillColor
        this.triangles[index].fill = selectedFillColor;
        this.shapes[v].fill=this.triangles[index].fill;       // Assign the selected fill color to the fill property of the shape object
        selectedFillColor=this.pureColor
        this.cofill = false;
        this.pureColor = '#ffffff'; // Reset the pureColor to a default value or another selected fill color
          this.modifysh=this.shapes[v];
             this.ord=v;
              this.modify()
                 }
             if(this.coledge){
              this.un++;
              let selectedEdgeColor = this.pureColor; // Use the selected edge color
          this.triangles[index].stroke = selectedEdgeColor; 
          this.shapes[v].stroke=this.triangles[index].stroke; // Assign the selected edge color to the stroke property of the shape object
          this.coledge = false;
          this.pureColor = '#ffffff'; // Reset the pureColor2 to a default value or another selected edge color
                 this.modifysh=this.shapes[v];
                  this.ord=v;
                 this.modify() 
       
          }
       
       /*********************************************************************** */
        
     }
     else if(type==='circle')
     {
       this.shapeType = "Circle"
       let v=0;
     for(let i=0;i<this.shapes.length;i++)
        {
         // console.log(this.shapes[i].id)
          if(this.shapes[i]!==null)
          {
                  if(this.shapes[i].id===this.circles[index].id)
                  {
                    v=i;
                    break;
                  }
          }
        
        }
          console.log(v);
         if(this.cop)
        {
          this.un++;
          this.ord=v;
          console.log(this.shapes[v])
          await this.prototype();
          console.log(this.co)
          this.circles.push({...this.co})
          this.shapes.push({...this.co})
          this.cop = false
          this.shapeid++;
           
        }
          if(this.delete)
        {
          this.un++;
         
              this.circles.splice(index,1);

                this.delete=false;
                    this.ord=v;
                  this.modify2()
        }
        if (this.cofill) {
              this.un++;
        let   selectedFillColor = this.pureColor; // Store the selected fill color in a variable
        this.circles[index].fill = selectedFillColor; 
           this.shapes[v].fill=this.circles[index].fill;   // Assign the selected fill color to the fill property of the shape object
        selectedFillColor=this.pureColor
        this.cofill = false;
        this.pureColor = '#ffffff'; // Reset the pureColor to a default value or another selected fill color
             this.modifysh=this.shapes[v];
              this.ord=v;
            this.modify()
              
                 }
                if(this.coledge){
                  this.un++;
             let selectedEdgeColor = this.pureColor; // Use the selected edge color
          this.circles[index].stroke = selectedEdgeColor; 
          this.shapes[v].stroke=this.circles[index].stroke; // Assign the selected edge color to the stroke property of the shape object
          this.coledge = false;
          this.pureColor = '#ffffff'; // Reset the pureColor2 to a default value or another selected edge color
              this.modifysh=this.shapes[v];
              this.ord=v;
              this.modify()    
        
       
     }  
       
     }
     else if(type==='line')
     {
      let v=0;
       this.shapeType = "Line"
      
    for(let i=0;i<this.shapes.length;i++)
        {
          if(this.shapes[i]!==null)
          {
                  if(this.shapes[i].id===this.lines[index].id)
                  {
                    v=i;
                    break;
                  }
          }
        
        }
        console.log(v);
         if(this.cop)
        {
          this.un++;
          this.ord=v;
          console.log(this.shapes[v])
          await this.prototype();
          console.log(this.co)
          this.lines.push({...this.co})
          this.shapes.push({...this.co})
          this.cop = false
          this.shapeid++; 
           
        }
             if(this.delete)
        {
            this.un++;
              this.lines.splice(index,1);
                this.delete=false;
                  this.ord=v;
                  this.modify2()
        }
        if(this.coledge){
          this.un++;
             let selectedEdgeColor = this.pureColor; // Use the selected edge color
          this.lines[index].stroke = selectedEdgeColor; // Assign the selected edge color to the stroke property of the shape object
          this.coledge = false;
          this.shapes[v].stroke=this.lines[index].stroke;
          this.pureColor = '#ffffff'; // Reset the pureColor2 to a default value or another selected edge color
                  this.modifysh=this.shapes[v];
                    this.ord=v;
                  this.modify()
        }
     }
     /************************************************************ */
     else if(type==='rect')
     {
      let v=0;
       this.shapeType = "Rectangle"
   for(let i=0;i<this.shapes.length;i++)
        {
         // console.log(this.shapes[i].id)
          if(this.shapes[i]!==null)
          {
                  if(this.shapes[i].id===this.rectangles[index].id)
                  {
                    v=i;
                    break;
                  }
          }
        
        }
        console.log(v);
         if(this.cop)
        {
          this.un++;
          this.ord=v;
          console.log(this.shapes[v])
          await this.prototype();
          console.log(this.co)
          this.rectangles.push({...this.co})
          this.shapes.push({...this.co})
          this.cop = false
          this.shapeid++;
           
        }
             if(this.delete)
        {
             this.un++;
              this.rectangles.splice(index,1);
                this.delete=false;
                this.ord=v;
              this.modify2()
        }
        if (this.cofill) {
          this.un++;
        let selectedFillColor = this.pureColor; // Store the selected fill color in a variable
        this.rectangles[index].fill = selectedFillColor; // Assign the selected fill color to the fill property of the shape object
        //selectedFillColor=this.pureColor
        this.shapes[v].fill=this.rectangles[index].fill;
        this.cofill = false;
        this.pureColor = '#ffffff'; // Reset the pureColor to a default value or another selected fill color
                this.modifysh=this.shapes[v];
                this.ord=v;
                 this.modify()
                 }
        if(this.coledge){
          this.un++;
             let selectedEdgeColor = this.pureColor; // Use the selected edge color
          this.rectangles[index].stroke = selectedEdgeColor; // Assign the selected edge color to the stroke property of the shape object
          this.shapes[v].stroke=this.rectangles[index].stroke;
          this.coledge = false;
          this.pureColor = '#ffffff'; // Reset the pureColor2 to a default value or another selected edge color
               this.modifysh=this.shapes[v];
                this.ord=v;
               this.modify()   
        
       
     }
     }
     /*************************************************************** */
      else if(type==='ellipse') {
        let v=0;
         this.shapeType = "Ellipse"
   for(let i=0;i<this.shapes.length;i++)
        {
         // console.log(this.shapes[i].id)
          if(this.shapes[i]!==null)
          {
                  if(this.shapes[i].id===this.ellipses[index].id)
                  {
                    v=i;
                    break;
                  }
          }
        
        }
          console.log(v);
        if(this.cop)
        { 
          this.un++;
          this.ord=v;
          console.log(this.shapes[v])
          await this.prototype();
          console.log(this.co)
          this.ellipses.push({...this.co})
          this.shapes.push({...this.co})
          this.cop = false
          this.shapeid++;
           
        }
        if(this.delete)
        {
              this.un++;
              this.ellipses.splice(index,1);
                this.delete=false;
               this.modifysh=this.shapes[v];
                   this.ord=v;
                  this.modify2()

        }
          if (this.cofill) {
            this.un++;
      let selectedFillColor = this.pureColor;
      this.ellipses[index].fill = selectedFillColor;
      this.shapes[v].fill=this.ellipses[index].fill;
      this.cofill = false;
      this.pureColor = '#ffffff';
        this.modifysh=this.shapes[v];
           this.ord=v;
         this.modify()
    }

        if(this.coledge){
          this.un++;
           let selectedEdgeColor = this.pureColor; // Use the selected edge color
          this.ellipses[index].stroke = selectedEdgeColor; // Assign the selected edge color to the stroke property of the shape object
            this.shapes[v].stroke=this.ellipses[index].stroke;
          this.coledge = false;
          this.pureColor = '#ffffff'; // Reset the pureColor2 to a default value or another selected edge color
                 this.modifysh=this.shapes[v];
               this.ord=v;
            this.modify() 
       
     }
        }
      else if(type==='star') {
        let v=0;
         this.shapeType = "Star"
  for(let i=0;i<this.shapes.length;i++)
        {
         // console.log(this.shapes[i].id)
          if(this.shapes[i]!==null)
          {
                  if(this.shapes[i].id===this.stars[index].id)
                  {
                    v=i;
                    break;
                  }
          }
        
        }
          console.log(v);
        if(this.cop)
        { 
          this.un++;
          this.ord=v;
          console.log(this.shapes[v])
          await this.prototype();
          console.log(this.co)
          this.stars.push({...this.co})
          this.shapes.push({...this.co})
          this.cop = false
          this.shapeid++;
           
        }
      if(this.delete)
        {
              this.un++;
              this.stars.splice(index,1);
                this.delete=false;
               this.modifysh=this.shapes[v];
                   this.ord=v;
                  this.modify2()

        }
        if (this.cofill) {
            this.un++;
      let selectedFillColor = this.pureColor;
      this.stars[index].fill = selectedFillColor;
      this.shapes[v].fill=this.stars[index].fill;
      this.cofill = false;
      this.pureColor = '#ffffff';
        this.modifysh=this.shapes[v];
           this.ord=v;
         this.modify()
    }

        if(this.coledge){
          this.un++;
           let selectedEdgeColor = this.pureColor; // Use the selected edge color
          this.stars[index].stroke = selectedEdgeColor; // Assign the selected edge color to the stroke property of the shape object
            this.shapes[v].stroke=this.stars[index].stroke;
          this.coledge = false;
          this.pureColor = '#ffffff'; // Reset the pureColor2 to a default value or another selected edge color
          this.modifysh=this.shapes[v];
          this.ord=v;
          this.modify() 
       
     }
        }
       
     else if(type==='square')
     {
      console.log("xx");
      let v=0;
        this.shapeType = "Square"
    for(let i=0;i<this.shapes.length;i++)
        {
         // console.log(this.shapes[i].id)
          if(this.shapes[i]!==null)
          {
                  if(this.shapes[i].id===this.squares[index].id)
                  {
                    v=i;
                    break;
                  }
          }
        
        }
        console.log(v);
         if(this.cop)
        {
          console.log(this.shapes[v]);
          this.un++;
         this.ord=v;
          console.log(this.shapes[v])
          await this.prototype();
          console.log(this.co)
          this.squares.push({...this.co})
          this.shapes.push({...this.co})
          this.cop = false
          this.shapeid++;
           
           
        }
               if(this.delete)
        {
            this.un++;
              this.squares.splice(index,1);
                this.delete=false;
                  this.ord=v;
                this.modify2()
        }
      if (this.cofill) {
        this.un++;
        let   selectedFillColor = this.pureColor; // Store the selected fill color in a variable
        this.selectedColor2= selectedFillColor
        this.squares[index].fill = selectedFillColor; // Assign the selected fill color to the fill property of the shape object
        selectedFillColor=this.pureColor
          this.shapes[v].fill=this.squares[index].fill;
        this.cofill = false;
        this.pureColor = '#ffffff'; // Reset the pureColor to a default value or another selected fill color
          this.modifysh=this.shapes[v];
          this.ord=v;
           this.modify()
        
                 }
        if(this.coledge)
        {
          this.un++;
                  let selectedEdgeColor = this.pureColor; // Use the selected edge color
          this.squares[index].stroke = selectedEdgeColor; // Assign the selected edge color to the stroke property of the shape object
          this.coledge = false;
            this.shapes[v].stroke=this.squares[index].stroke;
          this.pureColor = '#ffffff'; // Reset the pureColor2 to a default value or another selected edge color
            this.modifysh=this.shapes[v];
            this.ord=v;
           this.modify()
                
        }         
       
       
     }

    },
 

    del()
    {
      this.rectangle=false;
      this.circ=false;
      this.ellips=false;
      this.str=false;
      this.lin=false;
      this.sqrt=false;
      this.tria=false;
      this.cofill=false;
      this.delete=true;
      this.coledge=false;
      this.bru=false;
      this.cop=false;
    },
      draw() {
        this.selectedid=-1;
        this.updateTransformer();
     if(this.rectangle)
      {
          this.shapeid++;
          this.isdraw = true;
      const stage = this.$refs.stage.getStage();
      if (stage) {
        const position = stage.getPointerPosition();
        if (position) {
          this.currentShape = {
            x: position.x,
            y: position.y,
            type:'Rectangle',
             fill:this.pureColor,
            stroke:this.pureColor2,
            strokeWidth:2,
            width: 250,
            height: 400,
              id:String(this.shapeid),
                rotation : 0,
                  scaleX : 1,
                 scaleY : 1
          };
          console.log(this.currentShape.x);
          console.log(this.currentShape.y);
        }
      }
      }
      else if(this.circ){
          this.shapeid++;
                this.isdraw = true;
      const stage = this.$refs.stage.getStage();
      if (stage) {
        const position = stage.getPointerPosition();
        if (position) {
          this.currentShape = {
            x: position.x,
            y: position.y,
            type:'Circle',
            fill:this.pureColor,
            stroke:this.pureColor2,
            strokeWidth:2,
            radius: 200,
               id:String(this.shapeid),
                 rotation : 0,
                     scaleX : 1,
                     scaleY : 1
          };
        }
      }
      }
      else if(this.ellips)
      {
          this.shapeid++;
           this.isdraw = true;
          const stage = this.$refs.stage.getStage();
          if (stage) {
            const position = stage.getPointerPosition();
            if (position) {
              this.currentShape = {
                x: position.x,
                y: position.y,
                type:'Ellipse',
                 fill:this.pureColor,
            stroke:this.pureColor2,
            strokeWidth:2,
              radiusX: 200,
              radiusY:130,
                id:String(this.shapeid),
                  rotation : 0,
                     scaleX : 1,
                     scaleY : 1
              };
            }
          }
      }
      else if(this.str)
      {
          this.shapeid++;
           this.isdraw = true;
          const stage = this.$refs.stage.getStage();
          if (stage) {
            const position = stage.getPointerPosition();
            if (position) {
              this.currentShape = {
                x: position.x,
                y: position.y,
                type:'Star',
                 fill:this.pureColor,
                 stroke:this.pureColor2,
               strokeWidth:2,
              innerRadius:130,
              outerRadius:200,
              numPoints:6,
                id:String(this.shapeid),
                  rotation : 0,
                     scaleX : 1,
                     scaleY : 1
              };
            }
          }
      }
      else if(this.lin)
      {
          this.shapeid++;
              this.isdraw = true;
          const stage = this.$refs.stage.getStage();
          if (stage) {
            const position = stage.getPointerPosition();
            if (position) {
              this.currentShape = {
                x: position.x,
                y: position.y,
                type:'Line',
            stroke:this.pureColor2,
            strokeWidth:4,
             points: [0, 0,200,150],
                 id:String(this.shapeid),
                   rotation : 0,
                     scaleX : 1,
                     scaleY : 1
              };
            }
          }
      }
      else if(this.sqrt)
      {
          this.shapeid++;
            this.isdraw = true;
          const stage = this.$refs.stage.getStage();
          if (stage) {
            const position = stage.getPointerPosition();
            if (position) {
              this.currentShape = {
              x: position.x,
            y: position.y,
               type:'Square',
            strokeWidth:2,
             fill:this.pureColor,
            stroke:this.pureColor2,
            width: 200,
            height: 200,
              id:String(this.shapeid),
                rotation : 0,
                     scaleX : 1,
                     scaleY : 1
              };
            }
          }
      }
      else if(this.tria)
      {
         this.shapeid++;
          this.isdraw = true;
          const stage = this.$refs.stage.getStage();
          if (stage) {
            const position = stage.getPointerPosition();
            if (position) {
              this.currentShape = {
               x: position.x,
                y: position.y,
                type:'Triangle',
                strokeWidth:2,
                fill:this.pureColor,
                stroke:this.pureColor2,
                radius:150,
                  id:String(this.shapeid),
                    rotation : 0,
                     scaleX : 1,
                     scaleY : 1
              };
            }
          }
      }
      else if(this.poly)
      {
             this.shapeid++;
          this.isdraw = true;
          const stage = this.$refs.stage.getStage();
          if (stage) {
            const position = stage.getPointerPosition();
            if (position) {
              this.currentShape = {
               x: position.x,
                y: position.y,
                type:'Polygon',
                strokeWidth:2,
                fill:this.pureColor,
                stroke:this.pureColor2,
                radius:150,
                  id:String(this.shapeid),
                     rotation : 0,
                     scaleX : 1,
                     scaleY : 1

              };
              
            }
          }
      }
      
   
        else if(this.bru)
      {
            this.isdraw = true;
          const stage = this.$refs.stage.getStage();
          if (stage) {
            const position = stage.getPointerPosition();
            if (position) {
             this.currentShape = {
            points: [position.x, position.y],
            stroke: this.pureColor2,
            strokeWidth: 4,
          };
            }
          }
        
      }
       this.selectedid=-1;
        this.updateTransformer();
      
        this.stopDrawing();
    },
    stopDrawing() {
      console.log(this.currentShape);
      this.un++;
          if (this.isdraw) {
        this.isdraw = false;
        console.log("xxxxx");
        if(this.circ)
        {
          this.shapeType = 'Circle';
                     this.circles.push({ ...this.currentShape });
                     this.shapes.push({...this.currentShape});
                 
        }
      
      else if(this.rectangle){
        this.shapeType = 'Rectangle';

          this.rectangles.push({...this.currentShape});
            this.shapes.push({...this.currentShape});
        
      }
      
      else if(this.ellips)
      {
        this.shapeType = 'Ellipse';

           this.ellipses.push({...this.currentShape});
             this.shapes.push({...this.currentShape});
      }
      else if(this.str)
      {
        console.log("brt");
        this.shapeType = 'Star';

           this.stars.push({...this.currentShape});
           this.shapes.push({...this.currentShape});
      }
           
      else if(this.lin)
      {
        this.shapeType = 'Line';

             this.lines.push({...this.currentShape});
               this.shapes.push({...this.currentShape});
      }
          
      else if(this.sqrt)
      {
        this.shapeType = 'Square';

                this.squares.push({...this.currentShape});
                  this.shapes.push({...this.currentShape});
      }
          
      else if(this.tria)
      {
        this.shapeType = 'Triangle';

             this.triangles.push({...this.currentShape}); 
                this.shapes.push({...this.currentShape});
      }
        else if(this.bru)
      {
          this.brus.push({...this.currentShape});
      }
      else if(this.poly)
      {
          this.shapeType = 'Polygon';
           this.polygons.push({...this.currentShape}); 
                this.shapes.push({...this.currentShape});
      }
      this.createShape();
        this.currentShape = null;
      }
    },
    async createShape(){
      await fetch('http://localhost:8080/create', {
        method: 'POST',
        body: (this.shapeType + JSON.stringify(this.currentShape)),
      }).catch(error => {
        console.error('Fetch error:', error);
      });
    },

    async modify()
    {
        await fetch('http://localhost:8080/modify', {
        method: 'POST',
        body: (this.ord + "{" + this.shapeType + JSON.stringify(this.modifysh)),
      }).catch(error => {
        console.error('Fetch error:', error);
      });
    },
    async prototype()
    {
      await fetch('http://localhost:8080/copy', {
        method: 'POST',
        body: (this.ord),
      })
      .then(res => res.json())
      .then(data => this.co = data)
      console.log(this.co)
    },
    async modify2()
    {
        await fetch('http://localhost:8080/delete', {
        method: 'POST',
        body: (this.ord + "," + this.shapeType),
      }).catch(error => {
        console.error('Fetch error:', error);
      });
    },
   async saving()
      {
        console.log(this.savejason)
        if(this.savjason){
        await fetch('http://localhost:8080/saveJson', {
          method: 'POST',
          body: this.path+".json",
        }).catch(error => {
          console.error('Fetch error:', error);
        });
      }
      if(this.savxml){
        await fetch('http://localhost:8080/saveXml', {
          method: 'POST',
          body: this.path + ".xml",
        }).catch(error => {
          console.error('Fetch error:', error);
        });
        console.log(this.savexml)
      }
      },

     async loading(){
      this.un = 0
      this.re = 0 
        if(this.lodjason){
        await fetch('http://localhost:8080/loadJson', {
          method: 'POST',
          body: (this.path + ".json"),
        })
        .then(res => res.json())
        .then(data => this.shapes = data)
        console.log(this.shapes)
        
      this.circles=[];
      this.lines=[];
      this.squares=[];
      this.rectangles=[];
      this.triangles=[];
      this.ellipses=[];
      this.stars=[];
      this.polygons = [];
   
         for(let i=0;i<this.shapes.length;i++)
      {
        if(this.shapes[i]!==null)
        {
               if(this.shapes[i].type==='Rectangle')
          {
             this.rectangles.push({...this.shapes[i]});
          }
          else if(this.shapes[i].type==='Circle')
          {
              this.circles.push({...this.shapes[i]});
          }
          else if(this.shapes[i].type==='Ellipse')
          {
            this.ellipses.push({...this.shapes[i]})
          }
          else if(this.shapes[i].type==='Star')
          {
            this.stars.push({...this.shapes[i]})
          }
         else  if(this.shapes[i].type==='Square')
          {
             this.squares.push({...this.shapes[i]});
          }
          else if(this.shapes[i].type==='Triangle')
          {
            this.triangles.push({...this.shapes[i]});
          }
         else if(this.shapes[i].type==='Line')
         {
             this.lines.push({...this.shapes[i]});
         }
         else if(this.shapes[i].type==='Polygon')
         {
              this.polygons.push({...this.shapes[i]});
         }
        }
        
         
      }
          if(this.shapes.length!==0)
          {
              this.shapeid=Number(this.shapes[this.shapes.length-1].id);
          }
          else
          { 
              this.shapeid=-1;  
          }
         
      }
      if(this.lodxml){
        this.un = 0
        this.re = 0
        await fetch('http://localhost:8080/loadXml', {
          method: 'POST',
          body: this.path+".xml",
        })
        .then(res => res.json())
        .then(data => this.shapes = data)
        console.log(this.shapes)
           
      this.circles=[];
      this.lines=[];
      this.squares=[];
      this.rectangles=[];
      this.triangles=[];
      this.ellipses=[];
      this.stars=[];
      this.polygons = [];
      
        for(let i=0;i<this.shapes.length;i++)
      {
        if(this.shapes[i]!==null)
        {
               if(this.shapes[i].type==='Rectangle')
          {
             this.rectangles.push({...this.shapes[i]});
          }
          else if(this.shapes[i].type==='Circle')
          {
              this.circles.push({...this.shapes[i]});
          }
          else if(this.shapes[i].type==='Ellipse')
          {
            this.ellipses.push({...this.shapes[i]})
          }
          else if(this.shapes[i].type==='Star')
          {
            this.stars.push({...this.shapes[i]})
          }
         else  if(this.shapes[i].type==='Square')
          {
             this.squares.push({...this.shapes[i]});
          }
          else if(this.shapes[i].type==='Triangle')
          {
            this.triangles.push({...this.shapes[i]});
          }
         else if(this.shapes[i].type==='Line')
         {
             this.lines.push({...this.shapes[i]});
         }
         else if(this.shapes[i].type==='Polygon')
         {
              this.polygons.push({...this.shapes[i]});
         }
        }
         
      }
        if(this.shapes.length!==0)
          {
              this.shapeid=Number(this.shapes[this.shapes.length-1].id);
          }
          else
          { 
              this.shapeid=-1;  
          }
    }

     },
        savejason(){
      this.savjason=true;
      this.savxml=false;
    },
    savexml(){
      this.savxml=true;
      this.savjason=false;
    }, 
      submity(){
        this.savdialog=false;
        this.pathdialog=true;
      } , 
      ok(){
        this.loaddialog=false;
        this.pathloaddialog=true;

      },
      save()
      {
          this.saving();
          this.savdialog=true;
      },  
      send(){
        var str=document.getElementById('path').value;
        for(let i=0 ;i<str.length;i++)
        {
          if(str[i]=='\\')
          {

            this.path+='\\'

          }
          this.path+=str[i];
        }
        console.log(this.savjason)
        console.log(this.savxml)
        console.log(this.path)
        this.pathdialog=false;
        this.saving();
        this.savjaso=false;
        this.savxml=false;
        this.path = ""
      },
      laod(){
        this.loaddialog=true;
      },
      loadjason(){
        this.lodjason=true;
        this.lodxml=false;

      },
      loadxml(){
        this.lodxml=true;
        this.lodjason=false;
      },
      open()
      {
        var str=document.getElementById('pathload').value;
        for(let i=0 ;i<str.length;i++)
        {
          if(str[i]=='\\')
          {

            this.path+='\\'

          }
          this.path+=str[i];
        }
        console.log(this.lodjason)
        console.log(this.lodxml)
        console.log(this.path)
        this.pathloaddialog=false;
        this.loading();
        this.lodjason=false;
        this.lodxml=false;
        this.path = ""

      },

     

async undo() {
  if (this.un !== 0) {
    await fetch('http://localhost:8080/undo', {
      method: 'GET',
    })
    .then(res => res.json())
    .then(data => this.shapes = data);

    console.log(this.shapes);

    this.circles = [];
    this.lines = [];
    this.squares = [];
    this.rectangles = [];
    this.triangles = [];
    this.ellipses = [];
    this.stars = [];
    this.polygons = [];

    // Create an array of promises to wait for each push operation to complete
    const pushPromises = this.shapes.map(shape => {
  if (shape !== null) {
    if (shape.type === 'Rectangle') {
      this.rectangles.push({ ...shape });
    } else if (shape.type === 'Circle') {
      this.circles.push({ ...shape });
    } else if (shape.type === 'Ellipse') {
      this.ellipses.push({ ...shape });
    } else if (shape.type === 'Star') {
      this.stars.push({ ...shape });
    } else if (shape.type === 'Square') {
      this.squares.push({ ...shape });
    } else if (shape.type === 'Triangle') {
      this.triangles.push({ ...shape });
    } else if (shape.type === 'Line') {
      this.lines.push({ ...shape });
    } else if (shape.type === 'Polygon') {
      this.polygons.push({ ...shape });
    }
  }
});


    // Wait for all promises to resolve before proceeding
    await Promise.all(pushPromises);

    this.un--;
    this.re++;
  }
},
     async Redo()
    {
     this.updateTransformer()
      if(this.re!==0)
      {
        

               await fetch('http://localhost:8080/redo', {
        method: 'GET',
      })
      .then(res => res.json())
      .then(data => this.shapes = data)
      
     console.log(this.shapes);
      this.circles=[];
      this.lines=[];
      this.squares=[];
      this.rectangles=[];
      this.triangles=[];
      this.ellipses=[];
      this.stars=[];
      this.polygons = [];
      
    for(let i=0;i<this.shapes.length;i++)
      {
        if(this.shapes[i]!==null)
        {
               if(this.shapes[i].type==='Rectangle')
          {
             this.rectangles.push({...this.shapes[i]});
          }
          else if(this.shapes[i].type==='Circle')
          {
              this.circles.push({...this.shapes[i]});
          }
          else if(this.shapes[i].type==='Ellipse')
          {
            this.ellipses.push({...this.shapes[i]})
          }
          else if(this.shapes[i].type==='Star')
          {
            this.stars.push({...this.shapes[i]})
          }
         else  if(this.shapes[i].type==='Square')
          {
             this.squares.push({...this.shapes[i]});
          }
          else if(this.shapes[i].type==='Triangle')
          {
            this.triangles.push({...this.shapes[i]});
          }
         else if(this.shapes[i].type==='Line')
         {
             this.lines.push({...this.shapes[i]});
         }
         else if(this.shapes[i].type==='Polygon')
         {
              this.polygons.push({...this.shapes[i]});
         }
        }
         
      }
      this.re--;
      this.un++;


        
      }
      
    },
     handleTransformEnd(e) {
      let shape;
      for(let i = 0; i < this.shapes.length; i++){
        if(this.shapes[i] !== null && this.shapes[i].id === this.selectedid)
          shape = this.shapes[i];
      }


      shape.x = e.target.x();
      shape.y = e.target.y();
      shape.rotation = e.target.rotation();
      shape.scaleX = e.target.scaleX();
      shape.scaleY = e.target.scaleY();

      this.ord=shape.id;
      this.shapeType=shape.type;
      this.modifysh=shape;

       this.un++;
        if(shape.type === "Square"){
            shape = this.squares.find((r) => r.id === this.selectedid)
            shape.x = e.target.x();
            shape.y = e.target.y();
            shape.rotation = e.target.rotation();
            shape.scaleX = e.target.scaleX();
            shape.scaleY = e.target.scaleY();
        }
        else if(shape.type === "Rectangle"){
            shape = this.rectangles.find((r) => r.id === this.selectedid)
            shape.x = e.target.x();
            shape.y = e.target.y();
            shape.rotation = e.target.rotation();
            shape.scaleX = e.target.scaleX();
            shape.scaleY = e.target.scaleY();
        }
        else if(shape.type === "Circle"){
            shape = this.circles.find((r) => r.id === this.selectedid)
            shape.x = e.target.x();
            shape.y = e.target.y();
            shape.rotation = e.target.rotation();
            shape.scaleX = e.target.scaleX();
            shape.scaleY = e.target.scaleY();
        }
        else if(shape.type === "Triangle"){
            shape = this.triangles.find((r) => r.id === this.selectedid)
            shape.x = e.target.x();
            shape.y = e.target.y();
            shape.rotation = e.target.rotation();
            shape.scaleX = e.target.scaleX();
            shape.scaleY = e.target.scaleY();
        }
        else if(shape.type === "Polygon"){
            shape = this.polygons.find((r) => r.id === this.selectedid)
            shape.x = e.target.x();
            shape.y = e.target.y();
            shape.rotation = e.target.rotation();
            shape.scaleX = e.target.scaleX();
            shape.scaleY = e.target.scaleY();
        }
        else if(shape.type === "Line"){
            shape = this.lines.find((r) => r.id === this.selectedid)
            shape.x = e.target.x();
            shape.y = e.target.y();
            shape.rotation = e.target.rotation();
            shape.scaleX = e.target.scaleX();
            shape.scaleY = e.target.scaleY();
        }
        else if(shape.type === "Ellipse"){
            shape = this.ellipses.find((r) => r.id === this.selectedid)
            shape.x = e.target.x();
            shape.y = e.target.y();
            shape.rotation = e.target.rotation();
            shape.scaleX = e.target.scaleX();
            shape.scaleY = e.target.scaleY();
        }
          else if(shape.type === "Star"){
            shape = this.stars.find((r) => r.id === this.selectedid)
            shape.x = e.target.x();
            shape.y = e.target.y();
            shape.rotation = e.target.rotation();
            shape.scaleX = e.target.scaleX();
            shape.scaleY = e.target.scaleY();
        }
        







      console.log(shape);
      this.modify();
      


    },
    handleStageMouseDown(e) {
      if (e.target === e.target.getStage()) {
        this.selectedid = '';
        this.updateTransformer();
        return;
        
      }

      const clickedOnTransformer =
        e.target.getParent().className === 'Transformer';
      if (clickedOnTransformer) {
        return;
      }

     
    
      const x= e.target.id();

      // console.log(x)
      let shape;
      for(let i = 0; i < this.shapes.length; i++){
        if(this.shapes[i] !== null && this.shapes[i].id === x)
          shape = this.shapes[i];
      }

      // const shape = this.shapes.find((r) => r.id === x);

      if (shape) {
        this.selectedid = x;
      } else {
        this.selectedid = '';
      }
      this.updateTransformer();
    },
    updateTransformer() {
      const transformerNode = this.$refs.transformer.getNode();
      const stage = transformerNode.getStage();
      const { selectedid } = this;
      console.log(selectedid);
      const selectedNode = stage.findOne('#' + String(this.selectedid));
      console.log(selectedNode);
      if (selectedNode === transformerNode.node()) {
        return;
      }

      if (selectedNode) {
        transformerNode.nodes([selectedNode]);
      } else {
        transformerNode.nodes([]);
      }
    },


  }
}

</script>





<style scoped>
@keyframes rotateAnimation {
    from {
        transform: rotate(0deg);
    }
    to {
        transform: rotate(360deg);
    }
}
.palette{
  width: 35px;
  height: 35px;
  overflow: hidden;
}

.bord{
  position: relative;
  height: 100vh;
}
  
.left-bar{
  position: absolute;
  top: 50%;
  left: 0;
  transform: translateY(-50%);
  display: flex;
  flex-direction: column;
  align-items: center; 
  background-color: #1f2e2e;
  margin-left: 20px;
  padding: 30px 10px;
  border-radius: 30px;
}

.custom-btn{
  width: 35px;
  height: 35px;
  border-radius: 50%;
  background-color: transparent;
  box-shadow: none;
  border: none;
  color: white;
  transition: background-color 0.3s ease;
}

.custom-btn:hover{
  animation: rotateAnimation 1s infinite;
  background-color: #b300b3;
}

hr{
  width: 100%;
}

</style>