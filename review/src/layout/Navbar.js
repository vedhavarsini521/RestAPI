import React from "react";
import { Link } from "react-router-dom";

export default function Navbar() {
  return (
    <div>
      <nav className="navbar navbar-dark bg-dark">
        <div className="container-fluid">
          <Link className="navbar-brand" to="/">
            Shopping
          </Link>
          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            
              <Link to="https://www.amazon.in/s?k=shoes&ref=nb_sb_noss" className="navbar-toggler-icon"></Link>
               
          
          </button>

          <Link className="btn btn-outline-light" to="/adduser">
            Shop List
          </Link>
        </div>
      </nav>
    </div>
  );
}