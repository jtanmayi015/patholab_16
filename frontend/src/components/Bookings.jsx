import axios from "axios";
import { useEffect, useState } from "react";
import Moment from "react-moment";

function Bookings(){
    const [bookTest,setbookTest]=useState([])
    const [show,setShow]=useState(false)
    const [details,setDetails]=useState([])

    useEffect(()=>{
        axios.get("http://localhost:5000/api/bookTest")
        .then(resp=>{
            console.log(resp.data)
            setbookTest(resp.data.data)
        })
    },[]);

    const showDetails=(bookTestId)=>{
        axios.get("http://localhost:5000/api/bookTest/"+bookTestId)
        .then(resp=>{
            console.log(resp.data)
            setDetails(resp.data.data.details)
        })
        setShow(true)
    }
    return (
        <div className="container-fluid ">
            <div className="row ">
                <div className="col-sm-7">
                <h4 className="p-2 text-center text-black font-weight-bold">Recent Booking</h4>
                <table className="table table-bordered table-sm table-light table-hover table-striped">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Booking Date</th>
                            <th>Amount</th>
                            <th>Patient</th>
                            <th>Action</th>                       
                        </tr>
                    </thead>
                    <tbody>
                        {bookTest.map(x=>(
                            <tr key={x.bookTestId}>
                                <td>{x.bookTestId}</td>
                                <td><Moment format="ddd, DD-MMM-YYYY">{x.bookTestDate}</Moment></td>
                                <td>&#8377; {x.payment.amount}</td>
                                <td>{x.patient.name}</td>
                                <td><button onClick={e=>showDetails(x.bookTestId)} className="btn btn-primary btn-sm">Show Details</button></td>
                            </tr>
                        ))}
                    </tbody>
                </table>  
                </div>
                <div className="col-sm-5">
                    {show ? <>
                    <h4 className="p-2">Booking Details</h4>
                    <table className="table table-bordered table-light table-hover table-striped table-sm">
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
                                <tr key={x.test.testid}>
                                    <td>{x.test.testid}</td>
                                    <td><img className="mr-2 float-left" src={"http://localhost:5000/"+x.test.photo} width="100" />
                                    {x.test.tname}<br/>
                                    {x.test.category.catname}
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

export default Bookings;