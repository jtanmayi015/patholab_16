const Testvalidation=(values)=>{
    let errors={}
    if(!values.tname){
        errors.tname="Test Name is required"
    }
    if(!values.price){
        errors.price="Price is required"
    } 
    if(!values.category){
        errors.category="Category is required"
    }   
    return errors;
}

export default Testvalidation;