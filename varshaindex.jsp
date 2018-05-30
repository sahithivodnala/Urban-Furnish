<html>
    <head>
        <title>Upload Image</title>
    </head>
    
    <body>
    
        <b>Upload | <a href="varshaview.jsp">View</a></b><br/><br/>
        <form action="UploadImage" method="post" enctype="multipart/form-data">
        
        	
			<div class=""> 
				<label class="header">Product Name<span>*</span> </label>
				<input type="text" id="name" name="product_name" placeholder="product name" title="Please enter your Full Name" required="">
				<div class="clear"></div>
			</div>
			<div class=""> 
				<label class="header">Category<span>*</span> </label>
				<input type="text" id="name" name="category" placeholder="category" title="Please enter the category" required="">
				<div class="clear"></div>
			</div>
			
			
			
			
			
					<div class="">
				<label class="enquiry">Product Description <span>*</span> </label>
				<textarea id="message" name="description" placeholder="description" title="Please enter the description"></textarea>
				<div class="clear"></div>
			</div>
			<div class=" ">	
				<label class="header header-1">Price <span>*</span> </label>	
				<input type="tel" id="usrtel" name="price" placeholder="price" title="Please enter the price" required="">
				<div class="clear"></div>
			</div>	
        
        
        
            <input type="file" name="image" required="required"/><br/><br/>
            <input type="submit"/>
        </form>
    </body>
</html>
