// let w1=new Promise(function (resolve,reject) {
//     setTimeout(() => {
//         console.log('set timeout 1 started');
//     }, 2000);
//    resolve(true);
// });
// let output=w1.then(()=>{
//     let w2=new Promise (function(resolve,reject){
//         setTimeout(() => {
//            console.log('set timeout 2 started'); 
//         }, 6000);
//         resolve("resolved w2");
//     });
//     return w2;
// });
// output.then((value)=> console.log(value));


// async function test(){
//     return 5;
// }
// console.log(test());



// async function utility(){
//     let delhiMausam=new Promise((resolve,reject)=>{
//         setTimeout(()=>{
//             resolve("delhi temp 34.c");
//         },5000);
//     });
//     let hydMausam=new Promise((resolve,reject)=>{
//         setTimeout(() => {
//             resolve("hydrabad is cool");
//         }, 6000);
//     });
//     let dM= await delhiMausam;
//     let hM= await hydMausam;
//     return [dM,hM];
// }
// console.log(utility());


//closure
// function init() {
//     var name="MOzila";
//     function displayName(){
//         console.log(name);
//     }
//     displayName();
// }
// init();


fetch('https://jsonplaceholder.typicode.com/todos/1')
      .then(response => response.json())
      .then(json => console.log(json))