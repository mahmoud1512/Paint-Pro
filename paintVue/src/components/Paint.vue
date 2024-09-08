<template>
<div class="container">
<div class="bord">
<v-stage :config="configKonva" ref="stage" @dblclick="draw"  @mousedown="handleStageMouseDown">
<v-layer>
<!-- drawing squares   -->
<!-- we assign index as access key for the object -->
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
strokeWidth: square.strokeWidth ,
draggable:true,
id:square.id,
rotation:square.rotation,
scaleX:square.scaleX,
scaleY:square.scaleY
}"
@transformend="handleTransformEnd"
@click="shapeClicked(square.id)"
@dragend="getNewPosition('square', index, $event)"   
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
strokeWidth: rect.strokeWidth ,
draggable:true,
id:rect.id,
rotation:rect.rotation,
scaleX:rect.scaleX,
scaleY:rect.scaleY
 
}"
@transformend="handleTransformEnd"
@click="shapeClicked(rect.id) "
@dragend="getNewPosition('rect', index, $event)"   
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
strokeWidth: circle.strokeWidth,
draggable:true,
id:circle.id,
 rotation:circle.rotation,
scaleX:circle.scaleX,
scaleY:circle.scaleY
}"
@transformend="handleTransformEnd"
@click="shapeClicked(circle.id)"
@dragend="getNewPosition('circle', index, $event)"     >

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
strokeWidth: ellipse.strokeWidth,
draggable:true,
id:ellipse.id,
 rotation:ellipse.rotation,
scaleX:ellipse.scaleX,
scaleY:ellipse.scaleY
}"
@transformend="handleTransformEnd"
@click="shapeClicked(ellipse.id)"
@dragend="getNewPosition('ellipse', index, $event)"   

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
strokeWidth: star.strokeWidth,
draggable:true,
id:star.id,
 rotation:star.rotation,
scaleX:star.scaleX,
scaleY:star.scaleY
}"
@transformend="handleTransformEnd"
@click="shapeClicked(star.id)"
@dragend="getNewPosition('star', index, $event)"   

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
strokeWidth: line.strokeWidth,
draggable:true,
id:line.id,
rotation:line.rotation,
scaleX:line.scaleX,
scaleY:line.scaleY
}"
@transformend="handleTransformEnd"
@click="shapeClicked(line.id)"
@dragend="getNewPosition('line', index, $event)"   
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
@click="shapeClicked(triangle.id)"
@dragend="getNewPosition('triangle', index, $event)"   
>
</v-regular-polygon>


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
/* eslint-disable */
import { ref } from "vue";
import { ColorInputWithoutInstance } from "tinycolor2";

export default  {
  name: 'Paint-',
  data() {
    return {
      value: null,
      selectedColor: '',
      selectedColor2: '',
      configKonva: {
          width: window.innerWidth,
          height: window.innerHeight,
      },
      pureColor: '#000000',
      pureColor2: '#000000', // Selected edge color
      rectangles:[],
      squares:[],
      lines:[],
      circles:[],
      ellipses:[],
      triangles:[],
      stars:[],
      isdraw: false,
      WillDrawRectangle:false,
      WillDrawCircle:false,
      WillDrawEllipse:false,
      WillDrawLine:false,
      WillDrawSquare:false,
      WillDrawTriangle:false,
      WillUseBrush:false,
      WillDrawStar:false,
      WillDelete:false,
      WillChangeColorfill:false,
      WillChangeColorEdge:false,
      WillCopy:false,
      currentShape:null,
      shapes:[],
      selectedshapeid: '',  //transform
        shapeType: '',
        ord:null,
        modifysh:null, 
        co:null,
        length:200,
        un:0,
        re:0,
        shapeid:0,
         brus:[]
    };
  },
  async mounted()
  {
    await fetch('http://localhost:8081/Reset', {
        method: 'GET',
      }).catch(error => {
        console.error('Fetch error:', error);
      });
    
  },
  
  methods: {
    setup() {
      const pureColor = ref<ColorInputWithoutInstance>("red");
      return{pureColor}
    },
    DeactivitateOptions()
    {
      this.WillDrawRectangle=false;
      this.WillDrawCircle=false;
      this.WillDrawEllipse=false;
      this.WillDrawLine=false;
      this.WillDrawSquare=false;
      this.WillDrawTriangle=false;
      this.WillUseBrush=false;
      this.WillDrawStar=false;
      this.WillDelete=false;
      this.WillChangeColorfill=false;
      this.WillChangeColorEdge=false;
      this.WillCopy=false;
    },
getNewPosition(type, index,e) {    //TODO
    
  },
    rect(){
      this.DeactivitateOptions();
      this.WillDrawRectangle=true;
    },
    brush(){
       this.DeactivitateOptions();
       this.WillUseBrush=true;
    },
    ellipse()
    {
       this.DeactivitateOptions();
       this.WillDrawEllipse=true;
    }, 
    star()
    {
      this.DeactivitateOptions();
      this.WillDrawStar=true;
    }, 
    circle()
    {
        this.DeactivitateOptions();
        this.WillDrawCircle=true;
    },
    line()
    {
      this.DeactivitateOptions();
      this.WillDrawLine=true;
    },
    square()
    {
      this.DeactivitateOptions();
      this.WillDrawSquare=true;
    },
    triangle()
    {
      this.DeactivitateOptions();
      this.WillDrawTriangle=true;
    },
    fill(){
      this.DeactivitateOptions();
      this.WillChangeColorfill=true;
    },
    edge(){
      this.DeactivitateOptions();
      this.WillChangeColorEdge=true;
    },
      copy()
    {
       this.DeactivitateOptions();
       this.WillCopy=true;
    },   
    del()
    {
      this.DeactivitateOptions();
      this.WillDelete=true;
    },
  async clr()
    {
      this.circles=[];
      this.lines=[];
      this.squares=[];
      this.rectangles=[];
      this.triangles=[];
      this.ellipses=[];
      this.shapes=[];
      this.stars =[];
      await fetch('http://localhost:8081/Clear', {
        method: 'GET',
      }).catch(error => {
        console.error('Fetch error:', error);
      });
      this.disapleTransformer();
    
    },
  
    async shapeClicked(id) { 
            console.log(id);
            let shape = this.shapes.find((obj) => obj.id === id);
            console.log(shape);   
      //Fill here 
      if(this.WillChangeColorfill&&shape.type!=='Line')
      {
         shape.fill=this.pureColor;
         if(shape.type==='Rectangle')
         {
           let rectangle = this.rectangles.find((x) => x.id === id);
           rectangle.fill=shape.fill;
         } 
         else if(shape.type==='Square')
         {
            let square = this.squares.find((x) => x.id === id);
           square.fill=shape.fill;
         }
         else if(shape.type==='Triangle')
         {
              let triangle = this.triangles.find((x) => x.id === id);
              triangle.fill=shape.fill;
         }
         else if(shape.type==='Ellipse')
         {
             let ellipse = this.ellipses.find((x) => x.id === id);
            ellipse.fill=shape.fill;
         }
         else if(shape.type==='Circle')
         {
              let circle = this.circles.find((x) => x.id === id);
           circle.fill=shape.fill;
         }
         else if(shape.type==='Star')
         {
                let star = this.stars.find((x) => x.id === id);
               star.fill=shape.fill;
         }  
      await fetch('http://localhost:8081/Modify', {
        method: 'POST',
        body: (shape.type +" "+String(id) +" " +JSON.stringify(shape)),
      }).catch(error => {
        console.error('Fetch error:', error);
      });
      }
       //Stroke here
      else if(this.WillChangeColorEdge)
      {
              shape.stroke=this.pureColor;
              if(shape.type==='Rectangle')
            {
              let rectangle = this.rectangles.find((x) => x.id === id);
              rectangle.stroke=shape.stroke;
            } 
            else if(shape.type==='Square')
            {
                let square = this.squares.find((x) => x.id === id);
              square.stroke=shape.stroke;
            }
            else if(shape.type==='Triangle')
            {
                  let triangle = this.triangles.find((x) => x.id === id);
                  triangle.stroke=shape.stroke;
            }
            else if(shape.type==='Ellipse')
            {
                let ellipse = this.ellipses.find((x) => x.id === id);
                ellipse.stroke=shape.stroke;
            }
            else if(shape.type==='Circle')
            {
                  let circle = this.circles.find((x) => x.id === id);
              circle.stroke=shape.stroke;
            }
            else if(shape.type==='Star')
            {
                    let star = this.stars.find((x) => x.id === id);
                  star.stroke=shape.stroke;
            }  
            else if(shape.type==='Line')
            {
                 let line = this.lines.find((x) => x.id === id);
                  line.stroke=shape.stroke;
            }
          await fetch('http://localhost:8081/Modify', {
            method: 'POST',
            body: (shape.type +" "+String(id) +" " +JSON.stringify(shape)),
          }).catch(error => {
            console.error('Fetch error:', error);
          });

      }
      //Delete Here
      else if(this.WillDelete)
      {      
              if(shape.type==='Rectangle')
            {
                this.rectangles=this.rectangles.filter((obj)=>obj.id!==id);
            } 
            else if(shape.type==='Square')
            {
                 this.squares=this.squares.filter((obj)=>obj.id!==id);
            }
            else if(shape.type==='Triangle')
            {
                 this.triangles=this.triangles.filter((obj)=>obj.id!==id);
            }
            else if(shape.type==='Ellipse')
            {
                 this.ellipses=this.ellipses.filter((obj)=>obj.id!==id);
            }
            else if(shape.type==='Circle')
            {
                 this.circles=this.circles.filter((obj)=>obj.id!==id);
            }
            else if(shape.type==='Star')
            {
               this.stars=this.stars.filter((obj)=>obj.id!==id);
            }  
            else if(shape.type==='Line')
            {
                 this.lines=this.lines.filter((obj)=>obj.id!==id);
            }
             this.shapes=this.shapes.filter((obj)=>obj.id!==id);
             this.disapleTransformer();
          await fetch('http://localhost:8081/Delete', {
            method: 'POST',
            body: (String(id)),
          }).catch(error => {
            console.error('Fetch error:', error);
          });
      }
     else if (this.WillCopy) {
          this.shapeid++;
          console.log("hhhhhhh");
          try {
            const response = await fetch('http://localhost:8081/Copy', {
              method: 'POST',
              body:(String(id) + " " + String(this.shapeid)),
            });
            
            this.shapes = await response.json();  
            //console.log(response.json());
          } catch (error) {
            console.error('Error during fetch:', error);
          }
          
          this.circles = [];
          this.lines = [];
          this.squares = [];
          this.rectangles = [];
          this.triangles = [];
          this.ellipses = [];
          this.stars = [];
          
          this.shapes.forEach(shape => {
            switch (shape.type) {
              case 'Circle':
                this.circles.push({ ...shape });
                break;
              case 'Rectangle':
                this.rectangles.push({ ...shape });
                break;
              case 'Star':
                this.stars.push({ ...shape });
                break;
              case 'Square':
                this.squares.push({ ...shape });
                break;
              case 'Triangle':
                this.triangles.push({ ...shape });
                break;
              case 'Line':
                this.lines.push({ ...shape });
                break;
              case 'Ellipse':
                this.ellipses.push({ ...shape });
                break;
            }
          });
          this.WillCopy=false;
      }


     
    },
      draw() {
        this.shapeid++;
        this.isdraw = true;
        this.updateTransformer();
     if(this.WillDrawRectangle)
      {
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
            width: 100,
            height: 150,
              id:String(this.shapeid),
                rotation : 0,
                  scaleX : 1,
                 scaleY : 1
          };
        }
      }
      }
      else if(this.WillDrawCircle){
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
            radius: 50,
            id:String(this.shapeid),
            rotation : 0,
            scaleX : 1,
            scaleY : 1
          };
        }
      }
      }
      else if(this.WillDrawEllipse)
      {
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
                 radiusX: 100,
                 radiusY:65,
                id:String(this.shapeid),
                  rotation : 0,
                     scaleX : 1,
                     scaleY : 1
              };
            }
          }
      }
      else if(this.WillDrawStar)
      {
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
              innerRadius:65,
              outerRadius:100,
              numPoints:6,
                id:String(this.shapeid),
                  rotation : 0,
                     scaleX : 1,
                     scaleY : 1
              };
            }
          }
      }
      else if(this.WillDrawLine)
      {
          const stage = this.$refs.stage.getStage();
          if (stage) {
            const position = stage.getPointerPosition();
            if (position) {
              this.currentShape = {
                x: position.x,
                y: position.y,
                type:'Line',
                stroke:this.pureColor2,
                strokeWidth:7,
                points: [0, 0,200,80],
                 id:String(this.shapeid),
                   rotation : 0,
                     scaleX : 1,
                     scaleY : 1
              };
            }
          }
      }
      else if(this.WillDrawSquare)
      {
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
            width: 100,
            height: 100,
              id:String(this.shapeid),
                rotation : 0,
                     scaleX : 1,
                     scaleY : 1
              };
            }
          }
      }
      else if(this.WillDrawTriangle)
      {
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
                radius:75,
                id:String(this.shapeid),
                rotation : 0,
                scaleX : 1,
                scaleY : 1
              };
            }
          }
      }
        this.updateTransformer();     
        this.stopDrawing();
    },
    stopDrawing() {
       if (this.isdraw) {
        this.isdraw = false;
        
        if(this.WillDrawCircle)
        {
          this.shapeType = 'Circle';
          this.circles.push({ ...this.currentShape });
          this.shapes.push({...this.currentShape});
                 
        }
      
      else if(this.WillDrawRectangle){
        this.shapeType = 'Rectangle';

          this.rectangles.push({...this.currentShape});
            this.shapes.push({...this.currentShape});
        
      }      
      else if(this.WillDrawEllipse)
      {
        this.shapeType = 'Ellipse';

           this.ellipses.push({...this.currentShape});
             this.shapes.push({...this.currentShape});
      }
      else if(this.WillDrawStar)
      {
        this.shapeType = 'Star';

           this.stars.push({...this.currentShape});
           this.shapes.push({...this.currentShape});
      }
           
      else if(this.WillDrawLine)
      {
        this.shapeType = 'Line';

             this.lines.push({...this.currentShape});
            this.shapes.push({...this.currentShape});
      }
          
      else if(this.WillDrawSquare)
      {
        this.shapeType = 'Square';

                this.squares.push({...this.currentShape});
                  this.shapes.push({...this.currentShape});
      }
          
      else if(this.WillDrawTriangle)
      {
            this.shapeType = 'Triangle';
             this.triangles.push({...this.currentShape}); 
                this.shapes.push({...this.currentShape});
      }
       this.createShape();
       console.log(this.currentShape);
        this.currentShape = null;

      }
    },
    async createShape(){
      if(this.currentShape!==null)
      {
            await fetch('http://localhost:8081/create', {
            method: 'POST',
            body: (this.shapeType +" "+String(this.shapeid) +" " +JSON.stringify(this.currentShape)),
          }).catch(error => {
            console.error('Fetch error:', error);
          });
      }
    
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
        }
         
      }  
     }
      
    },
    async handleTransformEnd(e) {
      let shape;
      for(let i = 0; i < this.shapes.length; i++){
        if(this.shapes[i] !== null && this.shapes[i].id === this.selectedid)
          shape = this.shapes[i];
      }
      console.log(shape);

      shape.x = e.target.x();
      shape.y = e.target.y();
      shape.rotation = e.target.rotation();
      shape.scaleX = e.target.scaleX();
      shape.scaleY = e.target.scaleY();

      this.ord=shape.id;
      this.shapeType=shape.type;
      this.modifysh=shape;

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

      await fetch('http://localhost:8081/Modify', {
        method: 'POST',
        body: (shape.type +" "+String(this.selectedid) +" " +JSON.stringify(shape)),
      }).catch(error => {
        console.error('Fetch error:', error);
      });


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

      
      let shape;
      for(let i = 0; i < this.shapes.length; i++){
        if(this.shapes[i] !== null && this.shapes[i].id === x)
          shape = this.shapes[i];
      }

      

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

   disapleTransformer()
   {
      const transform=this.$refs.transformer.getNode();
      transform.nodes([]);
   }

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