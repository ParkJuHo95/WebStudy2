/**
 * 
 */
document.addEventListener("DOMContentLoaded", ()=>{
	console.log(bootstrap); // 2
	
	$("[data-log-out]").on("click", (event)=>{
		 let $aTag = $(event.target);
		 let formSelector = $aTag.data("logOut");
		 $(formSelector).submit();
	});
});