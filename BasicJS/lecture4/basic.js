// {
//  var a=10;
// }
// console.log(a);

//combination of  two array 
// let first=[1,2,3,4];
// let second=[5,6,7,8];
// let combined=first.concat(second);

// for(let value of combined){
//     console.log(value);
// }

//slice
// let marks=[1,2,3,4,5,6,7,8];
// let sliced=marks.slice(2,7);
// console.log(sliced);

//spread operator
// let num1=[1,2,3,4];
// let num2=[5,6,7];
// let comb=[...num1,...num2];
// console.log(comb);


//Split array
// let message='This is my first message';
// let parts=message.split(' ');
// console.log(parts);


//Filtering array
 //let numbers=[1,2,-1,-4];
// let filtered=numbers.filter(function(value){
//     return value>0;
// });

// let filtered=numbers.filter(value=>value>=0);
// console.log(filtered);

//mapping Arrays
// let numbers =[7,8,9,10];
// let items=numbers.map(value=>'student_no'+value);
// console.log(items);


// function sum(a,b){
//     let total=0;
//     for(let value of arguments)
//         total=total+value;
//     return total;
// }
// let ans=sum(1,2,3,4);
// console.log(ans);

// function sum(num,value,...args){
//     console.log(args);
// }
// sum(1,2,3,4,5,6);

//getter Setter
let person={
    fName:'Mohan',
    lName:'verma',
    get fullName(){
        return `$(person.fName) $(person.lName)`;
    },
    set fullName(value){
        let parts=value.split(' ');
        this.fName=parts[0];
        this.lName=parst[1];
    }

};
console.log(person.fName);