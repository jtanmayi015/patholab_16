import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom/cjs/react-router-dom";

function MyTests(){
    const empid=sessionStorage.getItem("id");
    const [test,setTest]=useState([]);
    useEffect(()=>{
        axios.get("http://localhost:5000/api/test?empid="+empid)
        .then(resp=>{
            console.log(resp.data);
            setTest(resp.data.data);
            console.log(test)
        });
    },[])

    const deleteTest = (testid)=>{
        let resp=window.confirm('Are you sure to delete this test ?');
        if(resp){
            axios.delete("http://localhost:5000/api/test/"+testid)
            .then(resp=>{
                alert("Test deleted successfully")
                axios.get("http://localhost:5000/api/test?empid="+empid)
                .then(resp=>{
                    console.log(resp.data)
                    setTest(resp.data.data)
                    console.log(test)
                })
            })            
        }
    }
    
    return (
        <div className="container">
            <div className="card shadow bg-transparent text-black font-weight-bold">
                <div className="card-body">                    
            <h4>My Tests</h4>
            <table className="table table-bordered">
                <thead className="table-light">
                    <tr>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Action</th>                                
                    </tr>
                </thead>
                <tbody>
  {test && Array.isArray(test) && test.map(x => (
    <tr key={x.testid}>
      <td><img width="100" src={"http://localhost:5000/" + x.photo} className="img-thumbnail" />{x.tname}</td>
      <td>{x.category.catname}</td>
      <td>{x.descr}</td>
      <td>{x.price}</td>
      <td>
        <Link to={"/edit/" + x.testid} className="btn btn-primary btn-sm mr-2">Edit</Link>
        <button onClick={() => deleteTest(x.testid)} className="btn btn-danger btn-sm">Delete</button>
      </td>
    </tr>
  ))}
</tbody>

            </table>
        </div>
        
        </div>
            </div>
    )
}

export default MyTests;