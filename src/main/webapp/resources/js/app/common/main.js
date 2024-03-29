/**
 *  모든 컨텐츠 페이지에 공통 적용할 모듈
 */
$("a[data-go-link]").each(function(index, atag){
	const contextPath = $("body").data("contextPath");
	let fullUrl = contextPath + $(atag).data("goLink");
	$(atag).attr("href", fullUrl);
});