package kr.or.ddit.common.paging;

public abstract class AbstractFormBasePaginationRenderer implements PaginationRenderer{
	private String targetForm;

	public AbstractFormBasePaginationRenderer(String targetForm) {
		super();
		this.targetForm = targetForm;
	}
	
	public String getTargetForm() {
		return targetForm;
	}
}
