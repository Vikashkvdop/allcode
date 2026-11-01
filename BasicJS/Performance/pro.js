// const t1=performance.now();
// for(let i=1; i<=100; i++){
//     let newElement=document.createElement('p');
//     newElement.textContent='this is para'+i;
//     document.body.appendChild(newElement);
// }
// const t2=performance.now();
// console.log("this took"+(t2-t1)+"ms");


// //optimize code

// const t3=performance.now();
// let myDiv=document.createElement('div');
// for(let i=1; i<=100; i++){
//     let element=document.createElement('p');
//     element.textContent='this is para'+i;
//     myDiv.appendChild(element);

// }
// document.body.appendChild(myDiv);
// const t4=performance.now();
// console.log("this took"+(t4-t3)+"ms");



//Time delay function
// setTimeout(() => {
//     console.log("this is the first message");
// }, 5000);
// setTimeout(() => {
//  console.log("this is the second message");
// }, 3000);
// setTimeout(() => {
//     console.log("this is the third message");
// }, 1000);
  
  
//promise function
let mPromise=new Promise(function(resolve,reject){
    setTimeout(() => {
        console.log('i am inside promise');
    }, 5000);
    resolve(2000);
});
console.log('first');


async function test() {
    return 7;
}
console.log(test());