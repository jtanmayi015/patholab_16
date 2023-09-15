import axios from "axios";
import { useEffect } from "react";
import { useState } from "react";
import Moment from "react-moment";

function MyBookTest(){
    const [bookTest,setBookTest]=useState([])
    const [show,setShow]=useState(false)
    const [details,setDetails]=useState([])

    useEffect(()=>{
        axios.get("http://localhost:5000/api/bookTest?patientid="+sessionStorage.getItem("id"))
        .then(resp=>{
            console.log(resp.data)
            setBookTest(resp.data.data)
        })
    },[]);

    const showDetails=(bookTestid)=>{
        axios.get("http://localhost:5000/api/bookTest/"+bookTestid)
        .then(resp=>{
            console.log(resp.data)
            setDetails(resp.data.data.details)
        })
        setShow(true)
    }
    
    return (
        <div className="container-fluid text-black font-weight-bold">
            <div className="row">
                <div className="col-sm-7">
                <h4 className="p-2">My Bookings</h4>
                <table className="table table-bordered table-sm table-light table-striped">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Booking Date</th>
                            <th>Amount</th> 
                            <th>Action</th>                       
                        </tr>
                    </thead>
                    <tbody>
                        {bookTest.map(x=>(
                            <tr key={x.bookTestid}>
                                <td>{x.bookTestid}</td>
                                <td><Moment format="ddd, DD-MMM-YYYY">{x.bookTestDate}</Moment></td>
                                <td>&#8377; {x.payment.amount}</td>
                                <td><button onClick={e=>showDetails(x.bookTestid)} className="btn btn-primary btn-sm">Show Details</button></td>
                            </tr>
                        ))}
                    </tbody>
                </table>  
                </div>
                <div className="col-sm-5">
                    {show ? <>
                    <h4 className="p-2">Test Details</h4>
                    <table className="table table-bordered table-sm table-light table-striped">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Test</th>
                                <th>Price</th>
                                <th>Qty</th>
                            </tr>
                        </thead>
                        <tbody>
                            {details.map(x => (
                                <tr>
                                    <td>{x.test.testid}</td>
                                    <td><img className="mr-2 float-left" src={"http://localhost:5000/"+x.test.photo} width="100" />
                                    {x.test.tname}<br/>
                                    Category: {x.test.category.catname}<br/>                                    
                                    </td>
                                    <td>{x.test.price}</td>
                                    <td>{x.qty}</td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                    </> : ''}
                </div>
            </div>                
                              
        </div>
    )
}
export default MyBookTest;