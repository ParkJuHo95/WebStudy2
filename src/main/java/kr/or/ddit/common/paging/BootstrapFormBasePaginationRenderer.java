package kr.or.ddit.common.paging;

public class BootstrapFormBasePaginationRenderer extends AbstractFormBasePaginationRenderer {

	public BootstrapFormBasePaginationRenderer() {
		this("#pagingForm");
	}
	
	public BootstrapFormBasePaginationRenderer(String targetForm) {
		super(targetForm);
	}

	@Override
	public String renderPagination(PaginationInfo paging) {
		String aTagPtrn = "<li class='page-item'><a class='page-link' href='javascript:;' data-pg-role='pageLink' data-pg-page='%d' data-pg-target='"+ getTargetForm() +"'>%s</a></li>";
		String cPagePtrn = "<li class='page-item active'><span class='page-link'>%d</span></li>";
		
		int startPage = paging.getStartPage();
		int endPage = paging.getEndPage();
		int totalPage = paging.getTotalPage();
		int blockSize = paging.getBlockSize();
		int currentPage = paging.getCurrentPage();
		
		StringBuffer html = new StringBuffer();
		html.append("<nav>");
		html.append("<ul class='pagination justify-content-center'>");
		
		if(startPage > blockSize) {
			html.append(
					String.format(aTagPtrn, startPage - blockSize , "이전")	
			);
		}
		
		for(int page = startPage; page <= endPage; page++) {
			if(page==currentPage) {
				html.append(
					String.format(cPagePtrn, page)	
				);
			}else {
				html.append(
					String.format(aTagPtrn, page , page)	
				);
				
			}
			
		}
		
		if(endPage < totalPage) {
			html.append(
					String.format(aTagPtrn, endPage + 1 , "다음")	
			);
		}
		
		html.append("</ul>");
		html.append("</nav>");
		return html.toString();
	}

}
