import React, {useState} from 'react';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import Register_Tournament from './Register_Tournament';
import ShowTournament from './ShowTournaments';
import { Button } from 'react-bootstrap';
import { useLocation } from 'react-router-dom';
import KabaddiMain1 from '../Assests/KabaddiMain1.jpg';
import ShowMatches from './ShowMatches';
import KabaddiInfo from './KabaddiInfo';
import './MainNavbar.css';



const MainNavbar = () => 
{
  const [showRegisterTournament, setShowRegisterTournament] = useState(false);
  const [showTournament, setShowTournament]=useState(false);
  const [showMatches, setShowMatches]=useState(false);
  const [showKabaddi, setShowKabaddi]=useState(false);
  const location = useLocation();
  var loginData={};
  if(location.state){
    loginData = location.state.loginInfo;
    console.log(loginData);  
  }
  else{
    loginData ={
      phnNumber: '+919765819169',
      firstName: 'Aditya',
      lastName: 'Latpate'} 
  }
  
  const handleRegisterTournamentClick = () => {
    setShowTournament(false);
    setShowRegisterTournament(true);
    setShowMatches(false);
    setShowKabaddi(false);
  };

  const handleShowMatches = () => {
    setShowTournament(false);
    setShowRegisterTournament(false);
    setShowMatches(true);
    setShowKabaddi(false);
  }

  const handleKabaddiInfoClick = () => {
    setShowTournament(false);
    setShowRegisterTournament(false);
    setShowKabaddi(true);
    setShowMatches(false);
  }

  const handleShowTournamentClick = () => {
    setShowRegisterTournament(false)
    setShowTournament(true);
    setShowMatches(false);
    setShowKabaddi(false);
  };


  return(
    <div >
      <div>
        <Navbar bg="primary" data-bs-theme="dark">
          <Container>
            <Navbar.Brand href="/main" style={{paddingLeft:'8%'}}>Rapid Raider Scores</Navbar.Brand>
            <Nav className="me-auto">
              <NavDropdown title="Tournament" id="basic-nav-dropdown">
                  <NavDropdown.Item onClick={handleRegisterTournamentClick}>Register Tournament</NavDropdown.Item>
                  <NavDropdown.Item onClick={handleShowTournamentClick} >Tournaments</NavDropdown.Item>
              </NavDropdown>
              <Nav.Link onClick={handleShowMatches}>Matches</Nav.Link>
              <Nav.Link onClick={handleKabaddiInfoClick}>Kabaddi Rules</Nav.Link>
            </Nav>
          </Container>
          <Button style={{paddingRight:'10%'}} href='/login'>Logout</Button>
        </Navbar>
        {showRegisterTournament && <Register_Tournament />}
        {showTournament && <ShowTournament loginData={loginData}/>}
        {showMatches && <ShowMatches/>}
        {showKabaddi && <KabaddiInfo/>}
        <br /><br />
        {
          !showRegisterTournament && !showTournament && !showMatches && !showKabaddi &&
          <marquee behavior="scroll" direction="right" scrollamount="20">
            <p class="marquee-text">You Can Register Your Kabaddi Tournaments And Keep Track Of Your Scores!</p>
          </marquee>

        }
        {
          !showRegisterTournament && !showTournament && !showMatches && !showKabaddi &&
          <div class="marquee-container">
            <img src={KabaddiMain1} alt="Your image" class="marquee-image" />
          </div>

        }
      </div> 
    </div>
    
  );
};

export default MainNavbar;

