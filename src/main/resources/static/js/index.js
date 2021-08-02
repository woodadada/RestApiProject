$(function(){
	var typeText = '채소';
	var url = '/api/vegetables/product';
	
   $('#searchBtn').on('click', function(e){
	   var keyword = $('#keyword').val();
	   
	   var token = new URLSearchParams(window.location.hash).get('#access_token');
	   
	   if(token == '' || token == null){
		   alert('토큰 발급을 진행하세요.');
		   return;
	   }
	   
	   if(keyword != ''){
		   
		   var type = $('#productTp').val();
		   
		   changeType(type);
		   
		   $.ajax({
				url : url,
				data : 'name=' + keyword,
				type:'GET',
				dataType:'json',
				beforeSend: function (xhr) {
		            xhr.setRequestHeader("Content-type","application/json");
		            xhr.setRequestHeader("Authorization", 'Bearer ' + token);
		        },
				success:function(data){
					console.log(data);
					
					if(data != null){
						$('#tableBody').html('');
						$.each(data, function(i, d){
							var html;
							html += '<tr>';
							html += 	'<td>';
							html += 	i + 1;
							html += 	'</td>';
							html += 	'<td>';
							html += 	typeText;
							html += 	'</td>';
							html += 	'<td>';
							html += 	d.productNm;
							html += 	'</td>';
							html += 	'<td>';
							html += 	d.productPr;
							html += 	'</td>';
							html += '</tr>';			
							
							$('#tableBody').append(html);
						});
					}else{
						$('#tableBody').html('');
					}
				},error:function(e){
					alert('에러 코드 : ' + e.responseJSON.code + '\n' + e.responseJSON.message);
					$('#tableBody').html('');
				}
			});
	   }else{
		   alert('검색어를 입력하세요.');
	   }
   });
   
   var changeType = function(type){
	   if(type == 'vegetable'){
		   typeText = '채소';
		   url = '/api/vegetables/product'; 
	   }else{
		   typeText = '과일';
		   url = '/api/fruits/product';
	   }
   }
   
   $('#productBtn').on('click', function(e){
	   
	   var token = new URLSearchParams(window.location.hash).get('#access_token');
	   
	   if(token == '' || token == null){
		   alert('토큰 발급을 진행하세요.');
		   return;
	   }
	   
	   var type = $('#productTp').val();
	   
	   changeType(type);
	   
	   $.ajax({
			url : url,
			type:'GET',
			dataType:'json',
			beforeSend: function (xhr) {
	            xhr.setRequestHeader("Content-type","application/json");
	            xhr.setRequestHeader("Authorization", 'Bearer ' + token);
	        },
			success:function(data){
				console.log(data);
				
				if(data != null){
					$('#tableBody').html('');
					$.each(data, function(i, d){
						var html;
						html += '<tr>';
						html += 	'<td>';
						html += 	i + 1;
						html += 	'</td>';
						html += 	'<td>';
						html += 	typeText;
						html += 	'</td>';
						html += 	'<td>';
						html += 	d.productNm;
						html += 	'</td>';
						html += 	'<td>';
						html += 	'-';
						html += 	'</td>';
						html += '</tr>';			
						
						$('#tableBody').append(html);
					});
				}else{
					$('#tableBody').html('');
				}
			},error:function(e){
				alert('에러 코드 : ' + e.responseJSON.code + '\n' + e.responseJSON.message);
				$('#tableBody').html('');
			}
		});
	   
   });
   
   $('#tokenBtn').on('click', function(e){
	   location.href = '/oauth/authorize?client_id=client&response_type=token&scope=read';
	   
//	   $.ajax({
//			url : '/oauth/authorize?client_id=client&response_type=token&scope=read',
//			type:'POST',
//			success:function(data){
//				console.log(data);
//				
//			},error:function(e){
//				alert('에러 코드 : ' + e.responseJSON.code + '\n' + e.responseJSON.message);
//			}
//		});
   });
	   
}); // --> document.ready dom생성 후
