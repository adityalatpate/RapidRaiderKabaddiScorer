import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import MainNavbar from './Components/MainNavbar';
import {Routes, Route, BrowserRouter} from 'react-router-dom';
import LoginComponent from './Components/LoginComponent';
import AddTeamForm from './Components/AddTeamForm';
import RegisterNewTeam from './Components/RegisterNewTeam';


function App() {
  return (
    <div className='App-header'>      
      <BrowserRouter>
        <Routes>
          <Route index element = {<LoginComponent/>}/>
          <Route path = "/main" element = {<MainNavbar/>}/>
          <Route path = "/addteam" element = {<AddTeamForm/>}/>
          <Route path = "/makenewteam" element = {<RegisterNewTeam/>}/>       
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
