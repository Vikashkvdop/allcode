
//Event listener
// document.addEventListener('click',function(){
//     console.log('i clicked on document');
// });

//remove event listener
// function eventFunction(){
//     console.log('i have clicked on the document');
// }
// document.addEventListener('click',eventFunction);
// document.removeEventListener('click',eventFunction);


//default action prevent
// let links=document.querySelectorAll('p');
// let thirdLink=links[2];
// thirdLink.addEventListener('click',function(event){
//     event.preventDefault();
//     console.log('Nothing');

// });


let myDiv=document.createElement('div');

let element=document.querySelector('#wrapper');
element.addEventListener('click',function(event){
    if(event.target.nodeName==='SPAN'){
        console.log('span clicked'+event.target.textContent);
    }
});