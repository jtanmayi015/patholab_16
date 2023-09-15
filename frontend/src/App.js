import logo from './logo.svg';
import './App.css';
import Header from './components/Header';
import RegSupplier from './components/RegPathologist';
import NavBar from './components/NavBar';
import RegPatient from './components/RegPatient';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import AdminLogin from './components/AdminLogin';
import AdminProfile from './components/AdminProfile';
import AllPatients from './components/AllPatients';
import AllPathologist from './components/AllPathologist';
import PathologistLogin from './components/PathologistLogin';
import PatientLogin from './components/PatientLogin';
import PathologistProfile from './components/PathologistProfile';
import AddTest from './components/AddTest';
import MyTests from './components/MyTests';
import AllTests from './components/AllTests';
import EditTest from './components/EditTest';
import PatientProfile from './components/PatientProfile';
import MyBookTest from './components/MyBookTest';
import Bookings from './components/Bookings';
import ViewTest from './components/ViewTest';
import TopSlider from './components/TopSlider';
import Categories from './components/Categories';
import GoToTop from './components/GoToTop';
import Footer from './components/Footer';
import AboutUs from './components/AboutUs';
import ContactUs from './components/ContactUs';
import Team from './components/Team';
function App() {
  return (
    <div className="App">
      <Header />      
      
      <BrowserRouter>
      <NavBar />
      <div className="container-fluid p-2">
      
        <Switch>
          <Route component={AllTests} path="/" exact />
          <Route component={AllTests} path="/cats/:catid" />
          <Route component={RegSupplier} path="/regsupplier" />
          <Route component={RegPatient} path="/register" />          
          <Route component={AdminLogin} path="/alogin" />          
          <Route component={PathologistLogin} path="/slogin" />          
          <Route component={PatientLogin} path="/clogin" />          
          <Route component={AdminProfile} path="/aprofile" />          
          <Route component={PathologistProfile} path="/sprofile" />          
          <Route component={PatientProfile} path="/cprofile" />          
          <Route component={AllPatients} path="/customers" />          
          <Route component={AllPathologist} path="/sellers" />                  
          <Route component={Categories} path="/categories" />                  
          <Route component={Categories} path="/categories/:catid" />                  
          <Route component={AddTest} path="/add-product" />          
          <Route component={EditTest} path="/edit/:prodid" />          
          <Route component={MyTests} path="/myproducts" />          
          <Route component={MyBookTest} path="/myorders" />          
          <Route component={Bookings} path="/orders" />          
          <Route component={ViewTest} path="/cart" />
          <Route component={AboutUs} path="/about-us" />
          <Route component={ContactUs} path="/contact-us" />

        </Switch>
      </div>
        <GoToTop/>
        <Footer/>
        </BrowserRouter>
        
    </div>
  );
}

export default App;
