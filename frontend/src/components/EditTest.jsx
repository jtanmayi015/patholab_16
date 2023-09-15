import axios from "axios";
import { useEffect, useState } from "react";
import { useHistory, useParams } from "react-router-dom";
import productvalidation from "../validations/Testvalidation";

function EditTest(){
    console.log("Edit test page")
    const empId=sessionStorage.getItem("id")
    const [cats,setcats]=useState([])
    const {testid}=useParams()
    const [test,setTest]=useState({
        "testid":testid,
        "tname":"",
        "category":"",
        "descr":"",
        "price":"",
        "emp":empId
    })
    
    
    const [errors,setErrors]=useState({})
    const [submitted,setSubmitted]=useState(false)
    const history=useHistory()

    const handleInput=e=>{
        setTest({...test,[e.target.name]:e.target.value})
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

        axios.get("http://localhost:5000/api/test/"+testid)
        .then(resp=>{
            console.log(resp.data)
            setTest(resp.data)
        })
    },[])
    
    useEffect(()=>{        

        if(Object.keys(errors).length===0 && submitted){            
            console.log(test)
            axios.put("http://localhost:5000/api/test/"+testid,test)
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
        <div className="container-fluid text-black font-weight-bold">
                    <div className="row">
                        <div class="col-sm-3">
                            <img width="300" src={"http://localhost:5000/"+test?.photo} />
                        </div>
                        <div className="col-sm-9">
                            <h4 className="text-center p-2">
                                Edit Test Form (Test ID : )
                            </h4>
                            <form onSubmit={handleSubmit}>
                            <div className="form-group form-row">
                                <label className="col-sm-4 form-control-label">Test Name</label>
                                <div className="col-sm-8">
                                    <input type="text" name="tname" value={test?.tname} onChange={handleInput} className="form-control" />
                                    {errors.tname && <small className="text-danger float-right">{errors.tname}</small>}
                                </div>
                                
                            </div>                            
                            <div className="form-group form-row">
                                <label className="col-sm-4 form-control-label">Category</label>
                                <div className="col-sm-8">
                                    <select name="category" value={test?.category.id} onChange={handleInput} className="form-control">
                                        <option value="">Select Category</option>
                                        {cats.filter(x=>x.isactive).map(x=>(
                                            <option value={x.id}>{x.catname}</option>
                                        ))}                                            
                                    </select>   
                                    {errors.category && <small className="text-danger float-right">{errors.category}</small>}                    
                                </div>                        
                            </div>
                            <div className="form-group form-row">
                                <label className="col-sm-4 form-control-label">Price</label>
                                <div className="col-sm-8">
                                    <input type="number" name="price" value={test?.price} onChange={handleInput} className="form-control" />
                                    {errors.price && <small className="text-danger float-right">{errors.price}</small>}
                                </div>                                
                            </div>
                            <div className="form-group form-row">
                                <label className="col-sm-4 form-control-label">Description</label>
                                <div className="col-sm-8">
                                    <input type="text" name="descr" value={test?.descr} onChange={handleInput} className="form-control" />
                                    {errors.descr && <small className="text-danger float-right">{errors.descr}</small>}
                                </div>                                
                            </div>                           
                            
                            <button className="btn btn-primary float-right">Update Test</button>
                            </form>
                        </div>
                    </div>
                </div>
    )
}

export default EditTest;
