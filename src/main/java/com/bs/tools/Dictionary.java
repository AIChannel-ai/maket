package com.bs.tools;

public class Dictionary implements Comparable<Dictionary>{

	private String key;
	private String value;
	private String table;
	private String input;
	private String source;
	private Boolean show;
	private Boolean listshow;
	private String def;
	private String style;
	private Integer order;
	private String type;
	private String required;
	private String readonly;

	public Dictionary() {
		super();
	}

	// getCategorys
	public Dictionary(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	// getRoles
	public Dictionary(String key, String value, Boolean show) {
		super();
		this.key = key;
		this.value = value;
		this.show = show;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getInput() {
		if (this.input == null)
			input = "text";
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Boolean getShow() {
		return show;
	}

	public void setShow(Boolean show) {
		this.show = show;
	}

	public Boolean getListshow() {
		return listshow;
	}

	public void setListshow(Boolean listshow) {
		this.listshow = listshow;
	}

	public String getDef() {
		return def;
	}

	public void setDef(String def) {
		this.def = def;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	@Override
	public int compareTo(Dictionary o) {
		return this.getOrder().compareTo(o.getOrder());
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRequired() {
		return required;
	}

	public void setRequired(String required) {
		this.required = required;
	}

	public String getReadonly() {
		return readonly;
	}

	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}
}
