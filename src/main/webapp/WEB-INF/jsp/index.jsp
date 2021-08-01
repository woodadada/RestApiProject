<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script src="/webjars/jquery/3.3.1/jquery.min.js"></script>
    <script src="/js/index.js"></script>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Bootstrap 4, from LayoutIt!</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

  </head>
  <body>
    <div class="container-fluid">
	<div class="row">
		<div class="col-md-12" style="margin: 20px">
			<h2>
				REST API 채소, 채소 검색 토큰 발급, 품목, 가격 검색
			</h2>
			
			<div class="form-inline" style="margin: 10px">
				<select class="selectpicker" id="productTp">
				    <option value="fruit">과일</option>
				    <option value="vegetable">채소</option>
				 </select>
				<input class="form-control mr-sm-2" type="text" style="margin: 10px" placeholder="검색어를 입력하세요." id="keyword" name="keyword"> 
				<button class="btn btn-primary my-2 my-sm-0" style="margin: 10px" id="searchBtn">
					검색
				</button>
				<button class="btn btn-primary my-2 my-sm-0" style="margin: 10px" id="productBtn">
					품목
				</button>
				<button class="btn btn-success my-2 my-sm-0" style="margin: 10px" id="tokenBtn">
					Token 발급
				</button>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>
							#
						</th>
						<th>
							Type
						</th>
						<th>
							Product
						</th>
						<th>
							Price
						</th>
					</tr>
				</thead>
				<!-- class="table-active"  table-success  table-warning table-danger-->
				<tbody id="tableBody">
					<tr>
						<td>
							1
						</td>
						<td>
							채소
						</td>
						<td>
							상추
						</td>
						<td>
							1,400
						</td>
					</tr>
					<tr>
						<td>
							1
						</td>
						<td>
							채소
						</td>
						<td>
							호박
						</td>
						<td>
							2,300
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
  </body>
</html>