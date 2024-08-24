# Steps to run in your machine
  Clone the Repo
  
  Open your project with your favorite ide
  
  Make the necessary changes -> Save
  
  go to SupplierApiApplication.class file present in package - com.makersharks.supplierapi
  
  Right click on the application Run as -> Spring Boot

# Api to save Supplier data ---  http://localhost:8080/api/supplier/query
# Api to fetch Supplier data --- http://localhost:8080/api/supplier/query/all?page=1&per_page=10
    page and per_page resquest parm isnot manditory 
    Required only if we want certain amount of data 
# Api to fetch Supplier data based on location , nature of business and manufacturing_process --- http://localhost:8080/api/supplier/query?location=China&nature=medium scale&process=moulding&page=2&per_page=3
  page and per_page resquest parm isnot manditory 
  Required only if we want certain amount of data
