package cn.jiuling.distributedapi.Vo;

public class TaskDetailVo {
	/*<type>2</type>
	<filename>1.avi</filename>
	<fileSize>24560000</fileSize>
	<sourceUrl>file://C:\VideoInvestigation\VIServer\DAT\AstVS_1v2\orgvideos\1\1\С С.avi</sourceUrl>
	<thickness>0</thickness>
	<sensitivity>0</sensitivity>
	<framerate>25</framerate>
	    <UDR_exist>0</UDR_exist>
	    <UDR_setting>
	      <udr>
	        <attr>1</attr>
	        <polynum>1</polynum>
	        <polyinfo>
	         <vertnum>5</vertnum>
	         <vertinfo>
	           <x>0.3</x> 
	           <y>0.1</y> 
	           <x>0.6</x> 
	           <y>0.3</y> 
	           <x>0.5</x> 
	           <y>0.6</y> 
	           <x>0.1</x> 
	           <y>0.6</y> 
	           <x>0.0</x> 
	           <y>0.3</y> 
	        </vertinfo>
	        </polyinfo>
	      </udr>
	    </UDR_setting>*/
	private Object type;
	private Object filename;
	private Object fileSize;
	private Object sourceUrl;
	private Object thickness;
	private Object sensitivity;
	private Object framerate;
	private Object UDR_exist;
	private Object UDR_setting;
	/*
	 	<obj_enable>0</obj_enable>
		<obj_type>0</obj_type>
		<obj_subtype>0</obj_subtype>
		<color_tolerance>0</color_tolerance>
		<enable_avgcolor>0</enable_avgcolor>
		<retrieve_avgcolor>0</retrieve_avgcolor>
		<enable_uppercolor>0</enable_uppercolor>
		<retrieve_uppercolor>0</retrieve_uppercolor>
		<enable_lowercolor>0</enable_lowercolor>
		<retrieve_lowercolor>0</retrieve_lowercolor>
		<enable_carnum>0</enable_carnum>
		<retrieve_carnum>0</retrieve_carnum>
	 */
	private Object obj_enable;
	private Object obj_type;
	private Object obj_subtype;
	private Object color_tolerance;
	private Object enable_avgcolor;
	private Object retrieve_avgcolor;
	private Object enable_uppercolor;
	private Object retrieve_uppercolor;
	private Object enable_lowercolor;
	private Object retrieve_lowercolor;
	private Object enable_carnum;
	private Object retrieve_carnum;
	/*
	 	<objHeight>0</objHeight>
		<objWidth>0</objWidth>
		<objDepth>0</objDepth>
		<startFrame>0</startFrame>
		<endFrame>5400000</endFrame>
		<submitDate>2013-03-28 09:51:28</submitDate>
		<summary_height>240</summary_height>
		<summary_width>320</summary_width>
		<isSetTripArea>1</isSetTripArea>
	 */
	private Object objHeight;
	private Object objWidth;
	private Object objDepth;
	private Object startFrame;
	private Object endFrame;
	private Object submitDate;
	private Object summary_height;
	private Object summary_width;
	private Object isSetTripArea;
	/* TODO 这里要处理一下这个对象
	 	<tripArea>
		<pnum>4</pnum>
		<dir>1</dir>
		<pinfo>
		<x1>0.169391</x1>
		<y1>0.132673</y1>
		<x2>0.968796</x2>
		<y2>0.215842</y2>
		<x3>0.789004</x3>
		<y3>0.893069</y3>
		<x4>0.075780</x4>
		<y4>0.841584</y4>
		</pinfo>
		</tripArea>
	 */
	private Object tripArea;
	/*
	<task_priority>0</task_priority>
	<taskName></ taskName >
		<enable_search_by_image>0</enable_search_by_image>
		<request_image_url></request_image_url>
		<request_mask_url></request_mask_url>
	<snap_type></snap_type>
	<drop_frm_rate></drop_frm_rate>*/
	private Object task_priority;
	private Object taskName;
	private Object enable_search_by_image;
	private Object request_image_url;
	private Object request_mask_url;
	private Object snap_type;
	private Object drop_frm_rate;

	public Object getType() {
		return type;
	}

	public void setType(Object type) {
		this.type = type;
	}

	public Object getFilename() {
		return filename;
	}

	public void setFilename(Object filename) {
		this.filename = filename;
	}

	public Object getFileSize() {
		return fileSize;
	}

	public void setFileSize(Object fileSize) {
		this.fileSize = fileSize;
	}

	public Object getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(Object sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public Object getThickness() {
		return thickness;
	}

	public void setThickness(Object thickness) {
		this.thickness = thickness;
	}

	public Object getSensitivity() {
		return sensitivity;
	}

	public void setSensitivity(Object sensitivity) {
		this.sensitivity = sensitivity;
	}

	public Object getFramerate() {
		return framerate;
	}

	public void setFramerate(Object framerate) {
		this.framerate = framerate;
	}

	public Object getUDR_exist() {
		return UDR_exist;
	}

	public void setUDR_exist(Object uDRExist) {
		UDR_exist = uDRExist;
	}

	public Object getUDR_setting() {
		return UDR_setting;
	}

	public void setUDR_setting(Object uDRSetting) {
		UDR_setting = uDRSetting;
	}

	public Object getObj_enable() {
		return obj_enable;
	}

	public void setObj_enable(Object objEnable) {
		obj_enable = objEnable;
	}

	public Object getObj_type() {
		return obj_type;
	}

	public void setObj_type(Object objType) {
		obj_type = objType;
	}

	public Object getObj_subtype() {
		return obj_subtype;
	}

	public void setObj_subtype(Object objSubtype) {
		obj_subtype = objSubtype;
	}

	public Object getColor_tolerance() {
		return color_tolerance;
	}

	public void setColor_tolerance(Object colorTolerance) {
		color_tolerance = colorTolerance;
	}

	public Object getEnable_avgcolor() {
		return enable_avgcolor;
	}

	public void setEnable_avgcolor(Object enableAvgcolor) {
		enable_avgcolor = enableAvgcolor;
	}

	public Object getRetrieve_avgcolor() {
		return retrieve_avgcolor;
	}

	public void setRetrieve_avgcolor(Object retrieveAvgcolor) {
		retrieve_avgcolor = retrieveAvgcolor;
	}

	public Object getEnable_uppercolor() {
		return enable_uppercolor;
	}

	public void setEnable_uppercolor(Object enableUppercolor) {
		enable_uppercolor = enableUppercolor;
	}

	public Object getRetrieve_uppercolor() {
		return retrieve_uppercolor;
	}

	public void setRetrieve_uppercolor(Object retrieveUppercolor) {
		retrieve_uppercolor = retrieveUppercolor;
	}

	public Object getEnable_lowercolor() {
		return enable_lowercolor;
	}

	public void setEnable_lowercolor(Object enableLowercolor) {
		enable_lowercolor = enableLowercolor;
	}

	public Object getRetrieve_lowercolor() {
		return retrieve_lowercolor;
	}

	public void setRetrieve_lowercolor(Object retrieveLowercolor) {
		retrieve_lowercolor = retrieveLowercolor;
	}

	public Object getEnable_carnum() {
		return enable_carnum;
	}

	public void setEnable_carnum(Object enableCarnum) {
		enable_carnum = enableCarnum;
	}

	public Object getRetrieve_carnum() {
		return retrieve_carnum;
	}

	public void setRetrieve_carnum(Object retrieveCarnum) {
		retrieve_carnum = retrieveCarnum;
	}

	public Object getObjHeight() {
		return objHeight;
	}

	public void setObjHeight(Object objHeight) {
		this.objHeight = objHeight;
	}

	public Object getObjWidth() {
		return objWidth;
	}

	public void setObjWidth(Object objWidth) {
		this.objWidth = objWidth;
	}

	public Object getObjDepth() {
		return objDepth;
	}

	public void setObjDepth(Object objDepth) {
		this.objDepth = objDepth;
	}

	public Object getStartFrame() {
		return startFrame;
	}

	public void setStartFrame(Object startFrame) {
		this.startFrame = startFrame;
	}

	public Object getEndFrame() {
		return endFrame;
	}

	public void setEndFrame(Object endFrame) {
		this.endFrame = endFrame;
	}

	public Object getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Object submitDate) {
		this.submitDate = submitDate;
	}

	public Object getSummary_height() {
		return summary_height;
	}

	public void setSummary_height(Object summaryHeight) {
		summary_height = summaryHeight;
	}

	public Object getSummary_width() {
		return summary_width;
	}

	public void setSummary_width(Object summaryWidth) {
		summary_width = summaryWidth;
	}

	public Object getIsSetTripArea() {
		return isSetTripArea;
	}

	public void setIsSetTripArea(Object isSetTripArea) {
		this.isSetTripArea = isSetTripArea;
	}

	public Object getTripArea() {
		return tripArea;
	}

	public void setTripArea(Object tripArea) {
		this.tripArea = tripArea;
	}

	public Object getTask_priority() {
		return task_priority;
	}

	public void setTask_priority(Object taskPriority) {
		task_priority = taskPriority;
	}

	public Object getTaskName() {
		return taskName;
	}

	public void setTaskName(Object taskName) {
		this.taskName = taskName;
	}

	public Object getEnable_search_by_image() {
		return enable_search_by_image;
	}

	public void setEnable_search_by_image(Object enableSearchByImage) {
		enable_search_by_image = enableSearchByImage;
	}

	public Object getRequest_image_url() {
		return request_image_url;
	}

	public void setRequest_image_url(Object requestImageUrl) {
		request_image_url = requestImageUrl;
	}

	public Object getRequest_mask_url() {
		return request_mask_url;
	}

	public void setRequest_mask_url(Object requestMaskUrl) {
		request_mask_url = requestMaskUrl;
	}

	public Object getSnap_type() {
		return snap_type;
	}

	public void setSnap_type(Object snapType) {
		snap_type = snapType;
	}

	public Object getDrop_frm_rate() {
		return drop_frm_rate;
	}

	public void setDrop_frm_rate(Object dropFrmRate) {
		drop_frm_rate = dropFrmRate;
	}

}
