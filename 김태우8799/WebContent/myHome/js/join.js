const join_text = document.querySelectorAll(".join_text");
const join_warning = document.querySelectorAll(".join_warning");
    for(let i = 0; i <join_text.length; i++){
        join_text[i].onblur = () =>{
            if(id_text.value.length ==0 ){
                id_warning.style.display = "block"
            }else{
                id_warning.style.display = "none"
            }
        }
    }

// const join_warning = document.querySelectorAll(".join_warning");
// for(let i = 0; i < join_text.length; i++){
//     join_text[i].addEventListener("blur", warning(join_warning[i]));
//     join_warning[i].addEventListener
// }
// function warning(){
//     alert(this.getAttribute("value"));
//     if(this.value.length == 0){
//         join_warning.style.display = "block";
//     }else{
//         join_warning.style.display = "none";  
//     }
// }

// id_text.onblur = () =>{
//     alert(id_text.value);
// }
// 이건 벗어나면 텍스트가 찍혀나옴