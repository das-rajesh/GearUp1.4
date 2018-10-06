<%@include file="shared/header.jsp" %>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h1 class="page-header">Report page</h1>
    <div class="col-md-3">
        <td><form action="/stock">
                <button type="submit" class="btn  btn-primary glyphicon glyphicon-book">Stock Summary</button>
            </form></td>    
        <td><form  action="/purchase">
                <button  type="submit" class="btn  btn-success glyphicon glyphicon-shopping-cart">Purchase</button>
            </form></td>                      
        <td><form  action="/sale">
                <button type="submit" class="btn  btn-success glyphicon glyphicon-gift">Sale</button>
            </form></td>


    </div>


</div>
</div>
</div>
</body>
</html>
