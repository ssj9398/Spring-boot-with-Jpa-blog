let index = {
	init:function(){
		btnSave = document.querySelector("#btn-save");
		btnSave.addEventListener("click",()=>{
			this.save();
		});
	},
	
	save:function(){
		let data={
			username:$("#username").val(),
			email:$("#email").val(),
			password:$("#password").val()
		}
		$.ajax().don().fail();  //ajax로 3개데이터를 json으로 insert요청
	}
}

index.init();