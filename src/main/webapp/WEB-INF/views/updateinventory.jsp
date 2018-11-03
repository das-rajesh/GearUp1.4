<%@include file="shared/header.jsp" %>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h2 class="page-header">Data Entry Form</h2>
    <h3 class="page-header">General Data</h3>
    <div class="col-md-4">

        <div class="form-group">
            <div class="form-row align-items-center">
                <div class="col-auto my-1">

                    <select  class="category-name" onchange="javascript:handleCategory(this)">
                        <option value="${id}">${category}</option>
                        <c:forEach var="category" items="${categories}"> 
                            <option value="${category.id}">${category.name}</option>
                        </c:forEach>

                    </select>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="form-row align-items-center">
                <div class="col-auto my-1">

                    <select  class="sub-category-name" onchange="javascript:handleSubCategory(this)">
                        <option value="${subcategoryId}">${subcategory}</option>
                        <c:forEach var="subcategory" items="${subCategories}">
                            <option value="${subcategory.id}">${subcategory.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="form-row align-items-center">
                <div class="col-auto my-1">

                    <select  class="sub-category-name" onchange="javascript:handleChildSubCategory(this)">
                        <option value="${childsubcategoryId}">${childsubcategoryname}</option>
                        <c:forEach var="childSubcategory" items="${childSubCategories}" >
                            <option value="${childSubcategory.id}">${childSubcategory.name}</option>

                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
        <form method="post" enctype = "multipart/form-data"   >
            <div class="form-group">
                <label for="exampleInputEmail1">Quantity</label>
                <input type="text" class="form-control" name="quantity"   placeholder="Enter quantity">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Price</label>
                <input type="text" class="form-control" name="price"  placeholder="Enter price">
            </div>
<!--            <div class="form-group">
                <label for="exampleFormControlSelect1">Size</label>
                <select class="form-control" name="size" id="exampleFormControlSelect1">
                    <option>S</option>
                    <option>M</option>
                    <option>X</option>
                    <option>XL</option>
                    <option>XXL</option>
                </select>
            </div>
            <div class="form-group">
                <label for="exampleFormControlSelect1"> Color</label>
                <select class="form-control" name="color" id="exampleFormControlSelect1">
                    <option>Black</option>
                    <option>White</option>
                    <option>Red</option>
                    <option>Blue</option>
                    <option>Green</option>
                    <option>Purple</option>
                    <option>Pink</option>
                    <option>Sky-Blue</option>
                    <option>Yellow</option>
                    <option>Brown</option>
                    <option>Grey</option>
                    <option>Orange</option>
                </select>
            </div>-->
            <div class="form-group">
                <label for="exampleFormControlFile1">Image</label>
                <input type="file" class="form-control-file" name="photo" id="exampleFormControlFile1">
            </div>
            <div class="form-group">
                <label for="exampleFormControlFile1">Image</label>
                <input type="hidden" class="form-control-file" name="name" value="${childsubcategoryname}">
            </div>
            <div class="ven">
                <h3 class="page-header">Purchase Information</h3>
            </div>
            <div class="form-group">
                <div class="form-row align-items-center">
                    <div class="col-auto my-1">

                        <select name="vendorId"  class="sub-category-name">
                            <option value="">Select Vendor</option>
                            <c:forEach var="vendor" items="${vendors}">
                                <option value="${vendor.id}">${vendor.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Add</button>
        </form>
    </div>
    <div class="col-md-8">
    </div>
</div>

<script>
    var link1;
    function handleCategory(elm)
    {
        // alert('s');
        link1 = elm.value;
        window.location = "/admin/updateinventory/subcategoryofcategory/" + elm.value;
    }</script>
<script>
    function handleSubCategory(elm)
    {
        window.location = "/admin/updateinventory/ch/" + elm.value + "/" + ${categoryId};
    }
</script>
<script>
    function handleChildSubCategory(elm)
    {
        window.location = "/admin/updateinventory/csc/" + ${subcategoryId} + "/" + elm.value;
    }
</script>  
<script>
    document.querySelector($".category-name").value = "${category}";
            document.querySelector($".sub-category-name").value = "${subcategory}";
</script>

<%@include file="shared/footer.jsp" %>
