import { createApp } from 'vue';
import App from './App.vue';
import VueKonva from 'vue-konva';
import Vue3ColorPicker from "vue3-colorpicker";
import "vue3-colorpicker/style.css";


import 'vuetify/styles'
import { createVuetify } from 'vuetify'
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'

const vuetify = createVuetify({
  components,
  directives,
})

const app = createApp(App);
app.use(VueKonva);
app.use(Vue3ColorPicker);
app.use(vuetify);
app.mount('#app');