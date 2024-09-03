<template>
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
</template>