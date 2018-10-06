<%@include file="shared/header.jsp" %>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h1 class="page-header">Add Child Sub-Category</h1>
    <div class="col-md-4">
        <div class="form-group">
            <div class="form-row align-items-center">
                <div class="col-auto my-1">

                    <select  class="category-name" onchange="javascript:handleSelect(this)">
                        <option value="${id}">${category}</option>
                        <c:forEach var="category" items="${categories}"> 
                            <option value="${category.id}">${category.name}</option>
                        </c:forEach>

                    </select>
                </div>
            </div>
        </div>
        <form method="post" > 

            <div class="form-group">
                <div class="form-row align-items-center">
                    <div class="col-auto my-1">

                        <select  class="sub-category-name" onchange="javascript:handleSelectchildsubd(this)">
                            <option value="${subcategoryId}">${subcategory}</option>
                            <c:forEach var="subcategory" items="${subCategories}">
                                <option value="${subcategory.id}">${subcategory.name} ${subcategory.id}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Child Sub-Category</label>
                <input type="text" class="form-control" name="name"   placeholder="Enter Child Sub category ">
                <input type="hidden" class="form-control" name="sub_categories_id" value="${subcategoryId}" >
            </div>
            <button type="submit" class="btn btn-primary">Add</button>
        </form>
    </div>   
    <div class="col-md-8">
    </div>
    <table class="table">
        <tr>
            <th>Id</th>
            <th>Child Sub-Category Name</th>
            <th>Quantity</th>
            <th>Action</th>
        </tr>

        <c:forEach var="childsubcategory" items="${childSubCategories}">
            <tr>
                <td>${childsubcategory.id}</td>
                <td>${childsubcategory.name}</td>
                <td>${childsubcategory.quantity}</td>
                <td>
                    <a href="/edit/${childsubcategory.id}">Edit
                    </a>
                    <a href="/delete/${childsubcategory.id}">Delete
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<script>
    var link1;
    function handleSelect(elm)
    {
        // alert('s');
        link1 = elm.value;
        window.location = "/childsubcategory/subcategoryofcategory/" + elm.value;
    }</script>
<script>
    function handleSelectchildsubd(elm)
    {
        window.location = "/childsubcategory/ch/" + elm.value + "/" + ${categoryId};
    }
</script>  
<script>
    document.querySelector($".category-name").value = "${category}";
            document.querySelector($".sub-category-name").value = "${subcategory}";
</script>
<%@include file="shared/footer.jsp" %>