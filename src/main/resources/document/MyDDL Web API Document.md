#MyDDL接口文档

##接口文档描述
---
###请求URL
接口地址以URI代替完整的URL，例如

    http://localhost/user/{pathVar}

将会简写成
    
    /user/{pathVar}
其中{}表示变量,由请求发起方传入相应的值。

###不同请求方法的含义
使用到的方法

    GET, POST, PUT, DELETE

+ GET   	获取
+ POST  	修改
+ PUT		添加
+ DELETE	删除

###参数
		* 表示必填
		
###出参：通用JSON格式
    {
    	/**
    	 *对应http response状态码.
    	 *2xx--正常
    	 *4xx--客户端异常
    	 *5xx--服务器内部异常
    	 */
	   	"statusCode":"200" // 返回状态码	int；对所有接口通用，后续接口描述中将省略
		
       	"result": { //存储请求成功的自定义数据；后续接口描述中只写result
        	...
       	}
    	"errorCodeObject": { // 错误时会返回的错误码；对所有接口通用，后续接口描述中将省略
			"errorCode":"ERROR_SYSTEM",
			"errorMsg":"系统错误"
		}
    }

##用户信息相关接口

###获取用户信息
####GET /user/{userId}
###### 入参：
	* userId	int		用户id
#####出参：
    result: { //存储请求成功的自定义数据
       	userId: ...
       	userName: ...
       	userImage: 头像图片的url
       	userPhone: ...
       	userEmail: ...
       	mainScreenImage: 序号
       	deadlines: [
       		{
       			deadlineId: ...
       			deadlineName: ...
       			time: "yyyy-MM-dd hh:mm"
       			courseProject: {
       			    courseProjectId: ...
	       			courseProjectName: ...
       				courseProjectType: 字符串"course"或"project"
       				courseProjectNote: 注释
    	   			courseProjectImage: ...
       			}
       		},
       		...若干个
       	]
       	groups: [
       		{
       			groupId: ...
       			groupName: ...
       			groupImage: 某url
       		},
       		...
       	]
       	courseProjects: [
       		{
       			courseProjectId: ...
       			courseProjectName: ...
       			courseProjectType: 字符串"course"或"project"
       			courseProjectNote: 注释
       			courseProjectImage: ...
       		},
       		...
       	]
    }
        
###修改用户信息
####POST /user/{userId}
#####入参：
	* userId		int 	用户id
	  userName		String	修改后的名称
	  userImage		String	修改后的头像url
	  userPhone		String	修改后的电话号码
	  userEmail		String	修改后的Email
	  
#####出参：
	result: {
		"success"
	}
	
###删除用户
####DELETE /user/{userId}
#####入参：
	* userId		int 	用户id
	
#####出参：
	result: {
		"success"
	}
	
##deadline相关接口

###获取deadline信息
####GET /deadline/{deadlineId}
#####入参： 
	* deadlineId	int		deadline的id
	
#####出参：
	result: {
		deadlineId: ...
		deadlineName: ...
       	time: "yyyy-MM-dd hh:mm"
       	contactName: ...
       	contactPhone: ...
       	contactEmail: ...
       	deadlineNote: ...
       	deadlineImage: ...url
       	complete: true/false
       	courseProject: {
       		courseProjectId: ...
       		courseProjectName: ...
       		courseProjectType: 字符串"course"或"project"
     		courseProjectNote: 注释
       		courseProjectImage: ...
       	}
	}
	
###修改deadline信息
####POST /deadline/{deadlineId}
#####入参： 
	* deadlineId		int		deadline的id
	  deadlineName		String
	  time				String	"yyyy-MM-dd hh:mm"
	  courseProjectId	int
	  contactName		String
	  contactPhone		String
	  contactEmail		String
	  deadlineNote		String
	  deadlineImage		String
	  complete			String	true/false
	  
#####出参：
	result: {
		"success"
	}
	
###新增deadline
####PUT /deadline
##### 入参：
	* deadlineName		String
	* courseProjectId	int
	* userId			int
	* time				String	"yyyy-MM-dd hh:mm"
	  contactName		String
	  contactPhone		String
	  contactEmail		String
	  deadlineNote		String
	  deadlineImage		String

#####出参：
	result: {
		deadlineId: ...
	}
	
###删除deadline
####DELETE /deadline/{deadlineId}
#####入参：
	* deadlineId	int		deadline的id
	
#####出参：
	result: {
		"success"
	}
	
##group相关接口

###获取group信息
####GET /group/{groupId}
#####入参：
	* groupId	int		group的id
	
#####出参：
	result: {
		groupId: ...
		groupName: ...
		groupImage: ...url
		users: [
			{
				userId: ...
				userName: ...
			},
			...若干个
		]
		deadlines: [
			{
				deadlineId: ...
				deadlineName: ...
			},
			...若干个
		]
	}
	
###修改group信息
####POST /group/{groupId}
#####入参： 
	* groupId		int		group的id
	  groupName		String
	  groupImage	String	url
	  
#####出参：
	result: {
		"success"
	}
	
###新增group
####PUT /group
#####入参：
	* groupName		String
	  groupImage	String	url

#####出参：
	result: {
		groupId: ...
	}
	
###删除group
####DELETE /group/{groupId}
#####入参：
	* groupId		int		group的id
	
#####出参：
	result: {
		"success"
	}
	
###group增加用户
####PUT /group/{groupId}/user/{userId}
#####入参：
	* groupId		int
	* userId		int
	
#####出参：
	result: {
		"success"
	}
	
###group删除用户
####DELETE /group/{groupId}/user/{userId}
#####入参：
	* groupId		int
	* userId		int
	
#####出参：
	result: {
		"success"
	}
	
##courseProject相关接口

###获取courseProject信息
####GET /courseProject/{courseProjectId}
#####入参：
	* courseProjectId		int		course或project的id
	
#####出参：
	result: {
		courseProjectId: ...
		courseProjectName: ...
		courseProjectType: course/project
		courseProjectNote: ...
		courseProjectImage: ...
		deadlines: [
			{
				deadlineId: ...
				deadlineName: ...
			},
			...若干个
		]
	}

###修改courseProject信息
####POST /courseProject/{courseProjectId}
#####入参： 
	* courseProjectId		int		courseProject的id
	  courseProjectName		String	
	  courseProjectType		String	course/project
	  courseProjectNote		String
	  courseProjectImage	String
	  
#####出参：
	result: {
		"success"
	}
	
###新增courseProject
####PUT /courseProject
#####入参：
	* courseProjectId		int		courseProject的id
	* courseProjectName		String	
	* courseProjectType		String	course/project
	  courseProjectNote		String
	  courseProjectImage	String

#####出参：
	result: {
		courseProjectId: ...
	}
	
###删除courseProject
####DELETE /courseProject/{courseProjectId}
#####入参：
	* courseProjectId		int
	
#####出参：
	result: {
		"success"
	}
	

