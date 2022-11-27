// import Message from './message.js';
// var token = null;
// const myApp = {
//
//     // Préparation des données
//     data() {
//         console.log("data");
//         return {
//             counter: 1,
//             message: "Hello",
//             list: [10, 20, 30],
//             axios: null,
//             movies : null,
//             movie : null,
//             edit : null,
//             errors : [],
//             xuser : null,
//         }
//     },
//
//     // Mise en place de l'application
//     mounted() {
//         console.log("Mounted ");
//         this.axios = axios.create({
//             baseURL: 'http://localhost:8081/api/',
//             timeout: 1000,
//             headers: { 'Content-Type': 'application/json' },
//         });
//         this.axios.get('/movies').then(r => {
//             this.movies = r.data;
//             console.log(r);
//         })
//
//     },
//
//     methods: {
//         // Place pour les futures méthodes
//         incCounter: function(step) {
//             this.$refs.info.change("test");
//             console.log("incremente le compteur ");
//             this.counter+=step;
//             this.axios.get('/movies/1')
//                 .then(r => {
//                     console.log("read movie 1 done");
//                     this.message = r.data;
//                 });
//         },
//         listMovies : function (){
//             this.axios.get('/movies').then(r => {
//                 this.movies = r.data;
//                 this.edit = null;
//                 this.movie = null;
//                 console.log(r);
//             })
//         },
//         showMovie : function(id){
//             console.log("show");
//             this.axios.get('/movies/'+id)
//                 .then(r => {
//                     console.log("read details of movie " + id + " done");
//                     this.movie = r.data;
//                 });
//         },
//         removeMovie: function(id) {
//             console.log(id);
//             this.axios.delete('/movies/'+id)
//                 .then(r => {
//                     console.log("removed movie "+ id +" done");
//                     this.axios.get('/movies').then(r => {
//                         this.movies = r.data;
//                         console.log(r);
//                     })
//                 });
//         },
//         editMovie: function(id){
//             console.log("edit");
//             this.axios.get('/movies/'+id).then(r => {
//                 this.edit = r.data;
//                 console.log(this.edit);
//             })
//         },
//         populateMovies:function(){
//             this.axios.patch('movies')
//                 .then(r => {
//                     this.axios.get('/movies').then(r => {
//                         this.movies = r.data;
//                         console.log(r);
//                     })
//                 });
//         },
//         submitMovie:function(id){
//             this.axios.put('/movies/'+ id,this.edit,{
//                 headers : {
//                     'Authorization' : "Bearer ${token}"
//                 }
//             })
//                 .then(r => {
//                     this.errors =  r.data;
//                     if(Object.keys(this.errors).length === 0)
//                         console.log("errors detected")
//                     this.axios.get('/movies').then(r => {
//                         this.movies = r.data;
//                         console.log(r);
//                         this.listMovies();
//                     })
//                 });
//         }
//     }
// }
//
// //Vue.createApp(myApp).mount('#myApp');
// const app = Vue.createApp(myApp);
// app.component('Message', Message);
// app.mount('#myApp');
