const borderinsertform = document.querySelector("borderinsertform");
const submitFlag = document.querySelector("submtFlag");
const insertButton = document.querySeletor("insertButton");

insertButton.onclick=()=>{
	submitFlag.value = "true";
	borderinsertform.submit();
}