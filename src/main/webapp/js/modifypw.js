$(function() {
	var $oldpw = $('#oldpw'),$newpw = $('#newpw');

	// 自定义一个非法字符方法
	$.validator.addMethod('illegal', function(v, e) {
		return !this.optional(e) || (/^[0-9a-zA-Z_]{5,16}$/).test(v);
	}, $.format('{0}不能有非法字符'));

	var vForm = $('form').validate( {
		onkeyup : false,
		messages : {
		   oldpw : {
				required : '旧密码不能为空',
				remote : "密码错误"
			},
			pw1 : {
				required : '新密码不能为空',
				rangelength : $.format('密码长度须大于{0},小于{1}')
			},
			pw2 : {
				required : '重复新密码不能为空',
				equalTo:"新密码不一致"
			}
		},
		rules : {
			oldpw : {
				required : true,
				remote : {
					url : '/login/valid.php',
					type : 'post',
					data : {
						oldpw : function() {
							return MD5_hexhash($oldpw.val());
						}
					}
				}
			},
			pw1 : {
				required : true,
				rangelength : [ 5, 16 ],
				illegal : [ '新密码' ]
			},
			pw2:{
				required : true,
				equalTo: "#newpw"
			}
		},
		submitHandler : function(form) {
			// 提交前密码做md5处理
			var data= {
					oldpw:MD5_hexhash($oldpw.val()),
			        newpw:MD5_hexhash($newpw.val())
			    }
			$.ajax({
				url:"/modifypassword.php",
				data:data,
				success:function(d){
				console.log(d);
				if(d===true){
					alert("修改成功");
				}else{
					alert("修改失败");
				}
			},error:function(){
				alert("修改失败");
			}
			});
	}
	});
})
