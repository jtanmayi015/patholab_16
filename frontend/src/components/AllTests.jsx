import axios from "axios";
import { useEffect, useState } from "react";
import ReactPaginate from "react-paginate";
import { useDispatch, useSelector } from "react-redux";
import {useHistory,useParams} from "react-router-dom";
import  Test from "./Test";
import TopSlider from "./TopSlider";

function AllTests(){
    const [test,setTest]=useState([])
    const [totalPage,setTotalPage]=useState(0)
    const {catid}=useParams()
    const state=useSelector((state)=>state);
    const [item,setItem]=useState({})
    const [qty,setQty]=useState(1)
    const dispatch=useDispatch()
    const history=useHistory()

    const [showDialog,setShowDialog]=useState("modal fade")
    const [display,setDisplay]=useState("none")
    
    const showModal=(test)=>{
        console.log("Child call parent")
        setShowDialog("modal fade show")
        setDisplay("block")
        setItem(test)
    }

    const checkItem =(testid)=>{
        return state.cart.findIndex(x=>x.testid===testid)<0
    }

    const closeDialog=()=>{        
        setShowDialog("modal fade")
        setDisplay("none")
    }

    const loadDataFromServer=(page=0,pagesize=8)=>{
        axios.get("http://localhost:5000/api/test/paginated?page="+page+"&pagesize="+pagesize)
            .then(resp=>{
                // console.log(resp.data.data.total)
                setTest(resp.data.data.tlist);
                setTotalPage(Math.ceil(resp.data.data.total/pagesize));
                console.log(test)
            }).catch(error => {
               console.error("Error fetching data:", error);
               // Handle the error appropriately, e.g., show an error message to the user.
  });
    }

    useEffect(()=>{
        console.log(catid)
        if(catid !== undefined){
            axios.get("http://localhost:5000/api/test/cats/"+catid)
            .then(resp=>{
                console.log(resp.data)
                setTest(resp.data)
                console.log(test)
            })
        }
        else {
            loadDataFromServer()
        }
    },[catid])
    const addToCart=item=>{  
        if(sessionStorage.getItem("userid")==null){
            alert("Please login first to buy test")
            history.push("/clogin")
        }
        else if(sessionStorage.getItem("role")!=="patients"){
            alert("Only patients can book test")
        }      
        else{            
            if(checkItem(item.testid))
            {     
                showModal() 
                setDisplay("none")
                setShowDialog("modal fade") 
                item.qty=qty         
                dispatch({type:'AddItem',payload:item})
                alert("your test Booking is done!!!")
            }
            else{                
                alert("You have already booked that test!!!")
            }
        }
    }


    const handlePageClick=({selected:selectedPage})=>{
        loadDataFromServer(selectedPage)
    }
    
    return (
        <>                 
        <TopSlider/>
        <div className="container-fluid" style={{width:"92%"}}>
            <div className="card shadow bg-transparent text-black font-weight-bold">
                <div className="card-body">
                <ReactPaginate 
                    previousLabel={"← Previous"}
                    nextLabel={"Next →"}
                    containerClassName={"pagination"}
                    pageCount={totalPage}
                    onPageChange={handlePageClick}
                    previousLinkClassName={"pagination__link"}
                    nextLinkClassName={"pagination__link"}
                    disabledClassName={"pagination__link--disabled"}
                    activeClassName={"pagination__link--active"} />
                    <div className="row">
                    {test.map(x=>(
                        <Test key={x.testid} x={x} showModal={showModal} />
                    ))}
                    </div>
                    
                </div>
            </div> 
            {display=="block"?( 
            <div className={showDialog} style={{zIndex:"1000",display:display}}>
                <div className="modal-dialog">
                    <div className="modal-content">
                        <div className="modal-header">
                            <h5>Book Test</h5>
                            <button onClick={closeDialog} className="close">&times;</button>
                        </div>
                        <div className="modal-body">
                            <div className="d-flex">
                                <img src={"http://localhost:5000/"+item.photo} style={{width:"200px"}}/>
                                <div className="ml-3">
                                    <h4 className="p-2 text-warning">{item.tname}</h4>
                                    <h5 className="px-2">About: {item.descr}</h5>
                                    <h5 className="px-2">Category: {item.category.catname}</h5>
                                    <h5 className="px-2">Pathologist: {item.employeeName}</h5>
                                    <h5 className="px-2">Price: &#8377; {item.price}</h5>
                                    <input type="number" min="1" value={qty} onChange={e=>setQty(e.target.value)}/>
                                </div>
                            </div>
                        </div>
                        <div className="modal-footer">
                            <button onClick={e=>addToCart(item)} className="btn btn-warning btn-sm">Book Test</button>
                        </div>
                    </div>
                </div>
            </div>) : ""}
        </div>
        </>
    )
}

export default AllTests;