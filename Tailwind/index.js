const countValue=document.querySelector('#counter');

function increament(){
    //get the value from ui
    let value=parseInt(countValue.innerText);
    //update the value
    value=value+1;
    //set the value onto ui
    countValue.innerText=value;

};
function decreament(){
    //get the value from ui
    let value=parseInt(countValue.innerText);
    //update value
    value=value-1;
    //set the value onto ui
    countValue.innerText=value
};