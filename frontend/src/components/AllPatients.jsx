import axios from "axios";
import { useEffect, useState } from "react";

function AllPatients(){
    const [patients,setPatients]=useState([])
    useEffect(()=>{
        axios.get("http://localhost:5000/api/patients")
        .then(resp=>{
            setPatients(resp.data)
            console.log(patients)
        })
    },[])
    
    return (
        <div className="container-fluid">
            <h4 className="p-2 text-center text-black font-weight-bold">All Patients</h4>
            <table className="table table-bordered table-light table-striped table-hover">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>City</th>
                        <th>Gender</th>
                        <th>Phone</th>
                        <th>User Id</th>
                        <th>Password</th>
                    </tr>
                </thead>
                <tbody>
                {patients.map(x=>(
                    <tr key={x.id}>
                        <td>{x.name}</td>
                        <td>{x.city}</td>
                        <td>{x.gender}</td>
                        <td>{x.phone}</td>
                        <td>{x.userid}</td>
                        <td>{x.pwd}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    )
}

export default AllPatients;