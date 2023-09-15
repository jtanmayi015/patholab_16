import axios from "axios";
import { useEffect, useState } from "react";
import { useHistory } from "react-router-dom";
import productvalidation from "../validations/Testvalidation";

function AddTest(){
    const empid=sessionStorage.getItem("id")
    const [cats,setcats]=useState([])
    const [test,setTest]=useState({
        "tname":"",
        "category":"",
        "price":"",
        "descr":"",
        "emp":empid
    })
    const [errors,setErrors]=useState({})
    const [selectedPhoto,setSelectedPhoto]=useState(null)
    const [submitted,setSubmitted]=useState(false)
    const history=useHistory()

    const handleInput=e=>{
        setTest({...test,[e.target.name]:e.target.value})
    }

    const handleFileInput=e=>{
        setSelectedPhoto(e.target.files[0])
    }

    const handleSubmit=e=>{
        e.preventDefault()
        setErrors(productvalidation(test))    
        setSubmitted(true)
    }
    useEffect(()=>{
        axios.get('http://localhost:5000/api/categories') 
        .then(resp=>setcats(resp.data))
        .catch(error=>alert(error))
    },[])

    useEffect(()=>{
        console.log(errors);
        if(Object.keys(errors).length===0 && submitted){
            const formData=new FormData()
            formData.append("pic",selectedPhoto)
            formData.append("tname",test.tname)
            formData.append("category",test.category)
            formData.append("price",test.price)
            formData.append("descr",test.descr)
            formData.append("emp",empid)
            console.log(test)
            axios.post("http://localhost:5000/api/test",formData)
            .then(resp=>{
                let result=resp.data.data;
                console.log(result) 
                alert("Test saved successfully")               
                history.push("/myproducts")
            })
            .catch(error=>{
                console.log("Error",error);
                alert("Error saving Test")
            })            
        }
    },[errors])
    return (
        <div className="container">
                <div className="card shadow bg-transparent text-black font-weight-bold">
                    <div className="card-body">
                    <div className="row">
                        <div className="col-sm-6 mx-auto">
                            <h4 className="text-center p-2">
                                Add Test Form
                            </h4>
                            <form onSubmit={handleSubmit}>
                            <div className="form-group form-row">
                                <label className="col-sm-4 form-control-label">Test Name</label>
                                <div className="col-sm-8">
                                    <input type="text" name="tname" value={test.tname} onChange={handleInput} className="form-control" />
                                    {errors.tname && <small className="text-danger float-right">{errors.tname}</small>}
                                </div>
                                
                            </div>                            
                            <div className="form-group form-row">
                                <label className="col-sm-4 form-control-label">Category</label>
                                <div className="col-sm-8">
                                    <select name="category" value={test.category} onChange={handleInput} className="form-control">
                                        <option value="">Select Category</option>
                                        {cats.filter(x=>x.isactive).map(x=>(
                                            <option value={x.id}>{x.catname}</option>
                                        ))}
                                    </select>   
                                    {errors.pcat && <small className="text-danger float-right">{errors.pcat}</small>}                    
                                </div>                        
                            </div>                            
                            <div className="form-group form-row">
                                <label className="col-sm-4 form-control-label">Price</label>
                                <div className="col-sm-8">
                                    <input type="number" name="price" value={test.price} onChange={handleInput} className="form-control" />
                                    {errors.price && <small className="text-danger float-right">{errors.price}</small>}
                                </div>                                
                            </div>
                            <div className="form-group form-row">
                                <label className="col-sm-4 form-control-label">Description</label>
                                <div className="col-sm-8">
                                    <input name="descr" value={test.descr} onChange={handleInput} className="form-control"/>  
                                    {errors.descr && <small className="text-danger float-right">{errors.brand}</small>}
                                </div>                                
                            </div>

                            <div className="form-group form-row">
                                <label className="col-sm-4 form-control-label">Photo</label>
                                <div className="col-sm-8">
                                    <input type="file" required name="photo" value={test.photo} onChange={handleFileInput} className="form-control-file" />                                    
                                </div>                                
                            </div>
                            
                            <button className="btn btn-primary float-right">Add_Test</button>
                            </form>
                        </div>
                    </div>
                </div>
                </div>
                </div>
    )
}

export default AddTest;
