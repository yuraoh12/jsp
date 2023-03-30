<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="LOGIN" />
<%@ include file="../common/head.jsp"%>

<script>
	function login__submit(form) {
		form.loginId.value = form.loginId.value.trim();
		
		if (form.loginId.value.length == 0) {
			alert('아이디를 입력해주세요');
			form.loginId.focus();
			
			return;
		}
		
		form.loginPw.value = form.loginPw.value.trim();
		
		if (form.loginPw.value.length == 0) {
			alert('비밀번호를 입력해주세요');
			form.loginPw.focus();
			
			return;
		}
		
		form.submit();
		
	}
</script>

<section class="mt-8 text-xl">
	<div class="container mx-auto px-3">
		<form action="doLogin" method="POST" onsubmit="login__submit(this); return false;">
			<div class="table-box-type-1">
				<table>
					<colgroup>
						<col width="200" />
					</colgroup>

					<tbody>
						<tr>
							<th>로그인 아이디</th>
							<td><input class="input input-bordered w-full max-w-xs" type="text" name="loginId" placeholder="아이디를 입력해주세요" /></td>
						</tr>
						<tr>
							<th>로그인 비밀번호</th>
							<td><input class="input input-bordered w-full max-w-xs" type="text" name="loginPw" placeholder="비밀번호를 입력해주세요" /></td>
						</tr>
						<tr>
							<td colspan="2">
								<input class="btn btn-active btn-ghost" type="submit" value="로그인"/>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</form>
		<div class="btns mt-2 flex justify-between">
			<button class="btn-text-link btn btn-active btn-ghost" type="button" onclick="history.back();">뒤로가기</button>
			<div>
				<a class="btn btn-active btn-ghost" href="findLoginId">아이디 찾기</a>
				<a class="btn btn-active btn-ghost" href="findLoginPw">비밀번호 찾기</a>
			</div>
		</div>
	</div>
</section>
<%@ include file="../common/foot.jsp"%>