<%@include file="shared/header.jsp" %>
<!--================Banner Area =================-->
<section class="banner_area">
    <div class="container">
        <div class="banner_text_inner">
            <h4>Contact Us</h4>
            <h5>Tell us about your story and your project.</h5>
        </div>
    </div>
</section>
<!--================End Banner Area =================-->
<div class="page-header">
    <h1>                                  Roles!!!!!.</h1>
</div>
<table class="table">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Action</th>
    </tr>
    <c:forEach var="role" items="${roles}">
        <tr>
            <td>${role.id}</td>
            <td>${role.name}</td>
            <td>
                Edit
                Delete
            </td>
        </tr>

    </c:forEach>

</table>


<%@include file="shared/footer.jsp" %>