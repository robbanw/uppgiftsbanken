//Mousover and mouseout eventhandlers for the divs.

function mHover(div,color){
div.style.backgroundColor=color;
}

function submitForm(type){
document.getElementById('typeID').value = type;
document.selectionForm.submit();
}