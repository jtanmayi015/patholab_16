import { useDispatch, useSelector } from "react-redux"
import { Link, useHistory } from "react-router-dom"
import LoginRegisterMenu from "./LoginRegisterMenu"

const RoleNavbar = ({ isLoggedIn }) => {
    const logout = e => {
        dispatch({ type: 'LogOut' })
        sessionStorage.clear();
        history.push("/");
    }
    const state = useSelector((state) => state);
    const history = useHistory()
    const dispatch = useDispatch()
    console.log(sessionStorage.getItem("role"), isLoggedIn)
    if (!isLoggedIn) {
        return (
            <LoginRegisterMenu />
        )
    }
    else if (sessionStorage.getItem("role") === "patients") {
        return (
            <ul className="navbar-nav ml-auto">
                <li className="nav-item active">
                    <Link className="nav-link" to="/cart">View Tests {state.cart.length === 0 ? '' :
                        <span className="badge badge-primary p-2">{state.cart.map(x => x.qty).reduce((a, b) => parseInt(a) + parseInt(b))}</span>}</Link>
                </li>
                <li className="nav-item active">
                    <Link className="nav-link" to="/cprofile">Profile</Link>
                </li>
                <li className="nav-item active">
                    <Link className="nav-link" to="/myorders">My Tests</Link>
                </li>
                <li className="nav-item active">
                    <Link className="nav-link" to="/contact-us">Contact Us</Link>
                </li>
                <li className="nav-item active">
                    <Link className="nav-link" to="/about-us">About Us</Link>
                </li>
                <li className="nav-item active">
                    <Link className="nav-link" onClick={logout} to="#">Logout</Link>
                </li>
            </ul>
        )
    }
    else if (sessionStorage.getItem("role") === "employee") {
        return (
            <ul className="navbar-nav ml-auto">
                <li className="nav-item active">
                    <Link className="nav-link" to="/sprofile">Profile</Link>
                </li>
                <li className="nav-item active">
                    <Link className="nav-link" to="/add-product">Add Tests</Link>
                </li>
                <li className="nav-item active">
                    <Link className="nav-link" to="/myproducts">All Tests</Link>
                </li>
                <li className="nav-item active">
                    <Link className="nav-link" to="/orders">Test Bookings</Link>
                </li>
                <li className="nav-item active">
                    <Link className="nav-link" onClick={logout} to="#">Logout</Link>
                </li>
            </ul>
        )
    }
    return (
        <ul className="navbar-nav ml-auto">
            <li className="nav-item active">
                <Link className="nav-link" to="/aprofile">Profile</Link>
            </li>
            <li className="nav-item active">
                <Link className="nav-link" to="/categories">Categories</Link>
            </li>
            <li className="nav-item active">
                <Link className="nav-link" to="/sellers">Pathologist</Link>
            </li>
            <li className="nav-item active">
                <Link className="nav-link" to="/customers">Patients</Link>
            </li>
            <li className="nav-item active">
                <Link className="nav-link" to="/orders">Test Bookings</Link>
            </li>
            <li className="nav-item active">
                <Link className="nav-link" onClick={logout} to="#">Logout</Link>
            </li>
        </ul>
    )

}



export default RoleNavbar;