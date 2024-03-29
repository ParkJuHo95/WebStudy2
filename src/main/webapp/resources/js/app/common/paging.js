/**
 * 특정 비즈니스에 종속되지 않는 형태로,
 * 목록 조회(페이징)처리에 공통 적용할 모듈.
 * 1. 페이징 처리는 hidden form 을 기반으로 함.(ex. #searchForm)
 * 2. 컨트롤러에서는 FormBasePaginationRenderer를 사용함. - 생성자를 통해 target form 을 결정함.
 * 3. data-pg 라는 접두어로 시작되는 데이터 속성을 기반으로 셀렉팅함.
 *     data-pg-role : pageLink(페이지 네비게이션 a 태그), searchUI(검색 조건 입력 UI), searchBtn(검색 버튼)
 *     data-pg-page : 페이지 네비게이션 a 태그에서 페이지 번호 설정에 사용.
 *     data-pg-target : 페이지 네비게이션에 사용할 target form 의 셀렉터 설정에 사용.	       
 *     data-pg-init-value : 검색 조건 초기화에 사용.
 */
$(":input[data-pg-init-value]").each(function(index, input){
	let $input = $(input);
	let initValue = $input.data("pgInitValue");
	$input.val(initValue);
});
$("[data-pg-role='searchUI']").on("click", '[data-pg-role="searchBtn"]', function(){
	let $searchUI = $(this).parents("[data-pg-role='searchUI']");
	let targetFormSelector = $searchUI.data("pgTarget");
	let $targetForm = $(targetFormSelector);
	
	$searchUI.find(":input[name]").each(function(index, input){
		let name = input.name;
		let value = $(input).val();
		$targetForm.find(`[name="${name}"]`).val(value);		
	});
	$targetForm.submit();
});
$(document).on("click", "a[data-pg-role='pageLink']", function(event){
		event.preventDefault();
		let page = $(this).data("pgPage");
// 		location.href = "?page=" + page;
		let targetFormSelector = $(this).data("pgTarget");
		let $targetForm = $(targetFormSelector);
		$targetForm.find('[name="page"]').val(page);
		$targetForm.submit();
		return false;
});








