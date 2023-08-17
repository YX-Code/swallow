sample
===
* 注释
```sql
select #{use("cols")} from sys_dept  where  #{use("condition")}
```
  

cols
===

	dept_id,parent_id,ancestors,dept_name,order_num,leader,phone,email,status,del_flag,create_by,create_time,update_by,update_time,short_name

updateSample
===

	dept_id=#{deptId},parent_id=#{parentId},ancestors=#{ancestors},dept_name=#{deptName},order_num=#{orderNum},leader=#{leader},phone=#{phone},email=#{email},status=#{status},del_flag=#{delFlag},create_by=#{createBy},create_time=#{createTime},update_by=#{updateBy},update_time=#{updateTime},short_name=#{shortName}

condition
===

	1 = 1  
	-- @if(!isEmpty(deptId)){
	 and dept_id=#{deptId}
	-- @}
	-- @if(!isEmpty(parentId)){
	 and parent_id=#{parentId}
	-- @}
	-- @if(!isEmpty(ancestors)){
	 and ancestors=#{ancestors}
	-- @}
	-- @if(!isEmpty(deptName)){
	 and dept_name=#{deptName}
	-- @}
	-- @if(!isEmpty(orderNum)){
	 and order_num=#{orderNum}
	-- @}
	-- @if(!isEmpty(leader)){
	 and leader=#{leader}
	-- @}
	-- @if(!isEmpty(phone)){
	 and phone=#{phone}
	-- @}
	-- @if(!isEmpty(email)){
	 and email=#{email}
	-- @}
	-- @if(!isEmpty(status)){
	 and status=#{status}
	-- @}
	-- @if(!isEmpty(delFlag)){
	 and del_flag=#{delFlag}
	-- @}
	-- @if(!isEmpty(createBy)){
	 and create_by=#{createBy}
	-- @}
	-- @if(!isEmpty(createTime)){
	 and create_time=#{createTime}
	-- @}
	-- @if(!isEmpty(updateBy)){
	 and update_by=#{updateBy}
	-- @}
	-- @if(!isEmpty(updateTime)){
	 and update_time=#{updateTime}
	-- @}
	-- @if(!isEmpty(shortName)){
	 and short_name=#{shortName}
	-- @}

jsonMap
===

    {
	"deptId":"dept_id",
	"parentId":"parent_id",
	"ancestors":"ancestors",
	"deptName":"dept_name",
	"orderNum":"order_num",
	"leader":"leader",
	"phone":"phone",
	"email":"email",
	"status":"status",
	"delFlag":"del_flag",
	"createBy":"create_by",
	"createTime":"create_time",
	"updateBy":"update_by",
	"updateTime":"update_time",
	"shortName":"short_name"
	}