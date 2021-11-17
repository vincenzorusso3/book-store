<!DOCTYPE html>
<html>

<head>
    <title>Footer with Logo</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
 
 <style>
 
 #myFooter {
    background-color: #3a3f46;
    color: white;
}

#myFooter .row {
    margin-bottom: 60px;
}

#myFooter .info{
    text-align: justify; 
    color: #afb0b1;
}

#myFooter ul {
    list-style-type: none;
    padding-left: 0;
    line-height: 1.7;
}

#myFooter h5 {
    font-size: 18px;
    color: white;
    font-weight: bold;
    margin-top: 30px;
}

#myFooter .logo{
    margin-top: 10px;
}

#myFooter .second-bar .logo a{
    color:white;
    font-size: 28px;
    float: left;
    font-weight: bold;
    line-height: 68px;
    margin: 0;
    padding: 0;
}

#myFooter a {
    color: #d2d1d1;
    text-decoration: none;
}

#myFooter a:hover,
#myFooter a:focus {
    text-decoration: none;
    color: white;
}

#myFooter .second-bar {
    text-align: center;
    background-color: #33373e;
    text-align: center;
}

#myFooter .second-bar a {
    font-size: 22px;
    color: #9fa3a9;
    padding: 10px;
    transition: 0.2s;
    line-height: 68px;
}

#myFooter .second-bar a:hover {
    text-decoration: none;
}

#myFooter .social-icons {
    float:right;
}


#myFooter .facebook:hover {
    color: #0077e2;
}

#myFooter .google:hover {
    color: #ef1a1a;
}

#myFooter .twitter:hover {
    color: #00aced;
}

@media screen and (max-width: 767px) {
    #myFooter {
        text-align: center;
    }

    #myFooter .info{
        text-align: center;
    }
}



/* CSS used for positioning the footers at the bottom of the page. */
/* You can remove this. */



.content{
   flex: 1 0 auto;
   -webkit-flex: 1 0 auto;
   min-height: 200px;
}

#myFooter{
   flex: 0 0 auto;
   -webkit-flex: 0 0 auto;
}
 
 </style>
 
</head>

<body>
<div class="content">
</div>
    <footer id="myFooter">
        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    <h5></h5>
                    <ul>
                        <li><a href="newhome.jsp">Home</a></li>
                        <li><a href="newregisterjquery.jsp">Sign up</a></li>
                       
                    </ul>
                </div>
          		
          		 <div class="col-sm-3">
                    
                </div>
           <div class="col-sm-3">
                  
                </div>
          
          		
          
                <div class="col-sm-3 info">
                    <h5></h5>
                    <p> Corso Vittorio Emanuele 12 </p>
                    <p> +39 089 111222333 </p>
                    <p> info@libreriasalernitana.com </p>
                    
                </div>
            </div>
        </div>
        <div class="second-bar">
           <div class="container">
                <h2 class="logo"><a href="#"> Libreria Salernitana </a></h2>
                <div class="social-icons">
                    <a href="#" class="twitter"><i class="fa fa-twitter"></i></a>
                    <a href="#" class="facebook"><i class="fa fa-facebook"></i></a>
                    <a href="#" class="google"><i class="fa fa-google-plus"></i></a>
                </div>
            </div>
        </div>
    </footer>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>