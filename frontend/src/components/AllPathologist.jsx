import axios from "axios";
import { useEffect, useState } from "react";

function AllPathologist(){
    const [employee,setEmployee]=useState([])

    const loaddata=()=>{
        axios.get("http://localhost:5000/api/emp")
        .then(resp=>{
            //console.log(resp.data.data)
            setEmployee(resp.data.data)
            console.log(employee)
        })
    }
    useEffect(()=>{
        loaddata()
    },[])

    const updateStatus=(emp)=>{
        let response=window.confirm('Are you sure to update this pathologist status ?');
        if(response){
           axios.post("http://localhost:5000/api/emp/status",{
            empid:emp.id,
            status:!emp.isactive
           })
           .then(resp=>{
                loaddata()
           })
        }
    }
    
    return (
        <div className="container-fluid text-black font-weight-bold">
            <h4 className="p-2 text-center">All Pathologist</h4>
            <table className="table table-bordered table-striped table-light table-hover">
                <thead className="table-dark">
                    <tr>
                        <th>Name</th>
                        <th>Details</th>
                        <th>User Id</th>
                        {/* <th>Certificate</th> */}
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                {employee.map(x=>(
                    <tr key={x.id}>
                        <td>{x.name}</td>
                        <td>
                            City: {x.city}<br/>
                            Phone: {x.phone}                            
                        </td>
                        <td>{x.userid}</td>
                        {/* <td><img style={{width:"200px",height:"200px"}} src={'http://localhost:5000/'+x.certificate}/></td> */}
                        <td>{x.isactive ? "Active":"Inactive"}</td>
                        <td>
                            {x.isactive ?(
                            <button onClick={(e)=>updateStatus(x)} className="btn btn-danger btn-sm">Deactivate</button>
                            ):(
                            <button onClick={(e)=>updateStatus(x)} className="btn btn-success btn-sm">Activate</button>
                            )}
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    )
}

export default AllPathologist;