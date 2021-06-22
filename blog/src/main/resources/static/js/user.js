let index = {
	init:function(){
		btnSave = document.querySelector("#btn-save");
		btnSave.addEventListener("click",()=>{ //function(){}, ()={} this를 바인딩하기 위해서!
			this.save();
		});
	},
	
	save:function(){
		let data={
			username:$("#username").val(),
			email:$("#email").val(),
			password:$("#password").val()
		}
		//console.log(data);
		
		//ajax호출 시 default가 비동기 호출
		//ajax로 3개데이터를 json으로 insert요청
		// ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환해줌
		$.ajax({
		type:"POST",
		url:"/blog/api/user", 
		data:JSON.stringify(data),  //http body데이터
		contentType:"application/json; charset=utf-8", //body데이터가 어떤타입인지 (MIME)
		dataType:"json" //요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열인데 json이라면 javascript object로 변경
		
		}).done(function(resp){
		console.log("회원가입 완료"+resp);
		location.href="/blog"
		}).fail(function(error){
		alert(JSON.stringify(error));
		});  
	}
}

index.init();