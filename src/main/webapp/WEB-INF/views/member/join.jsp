<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty sessionScope.member}">
    <script>location.href = "/member/myinfo";</script>
</c:if>

<main>
    <h2>회원가입</h2>
    <form name="joinfrm">
        <div>
            <label for="userid">아이디</label>
            <input type="text" id="userid" name="userid">
        </div>
        <div>
            <label for="passwd">비밀번호</label>
            <input type="password" id="passwd" name="passwd">
        </div>
        <div>
            <label for="repasswd">비밀번호 확인</label>
            <input type="password" id="repasswd" name="repasswd">
        </div>
        <div>
            <label for="name">이름</label>
            <input type="text" id="name" name="name">
        </div>
        <div>
            <label for="email">이메일</label>
            <input type="email" id="email" name="email">
        </div>
        <div>
            <label></label>
            <button type="button" class="btn btn-primary" id="joinbtn">입력완료</button>
            <button type="reset" class="btn btn-danger">입력취소</button>
        </div>
    </form>
</main>
<script src="/assets/js/member.js"></script>

