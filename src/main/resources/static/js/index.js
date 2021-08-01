$(function(){
	var typeText = '채소';
	var url = '';
	
   $('#searchBtn').on('click', function(e){
	   var keyword = $('#keyword').val();
	   
	   if(keyword != ''){
		   
		   var type = $('#productTp').val();
		   
		   changeType(type);
		   
		   $.ajax({
				url : url,
				data : 'name=' + keyword,
				type:'GET',
				dataType:'json',
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
		   url = '/vegetables/product'; 
	   }else{
		   typeText = '과일';
		   url = '/fruits/product';
	   }
   }
   
   $('#productBtn').on('click', function(e){
	   
	   var type = $('#productTp').val();
	   
	   changeType(type);
	   
	   $.ajax({
			url : url,
			type:'GET',
			dataType:'json',
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
	   alert('tokenBtn 클릭');
   });
	   
}); // --> document.ready dom생성 후
