import axios from "axios";
import React, { useEffect,useState } from "react";
import { Link, useParams } from "react-router-dom";

export default function ViewUser() {
  const [user, setUser] = useState({
    itemName: "",
    brand: "",
    price: "",
    discount: "",
    rating: ""
  });

  const { id } = useParams();

  useEffect(() => {
    loadUser();
  }, []);

  const loadUser = async () => {
    const result = await axios.get(`http://localhost:8080/user/${id}`);
    setUser(result.data);
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Item Details</h2>

          <div className="card">
            <div className="card-header">
              Details of items id : {user.id}
              <ul className="list-group list-group-flush">
                <li className="list-group-item">
                  <b>Item Name:</b>
                  {user.itemName}
                </li>
                <li className="list-group-item">
                  <b>Brand:</b>
                  {user.brand}
                </li>
                <li className="list-group-item">
                  <b>Price:</b>
                  {user.price}
                </li>
                <li className="list-group-item">
                  <b>Discount:</b>
                  {user.discount}
                </li>
                <li className="list-group-item">
                  <b>Rating:</b>
                  {user.rating}
                </li>
              </ul>
            </div>
          </div>
          <Link className="btn btn-primary my-2" to={"/"}>
            Back to Home
          </Link>
        </div>
      </div>
    </div>
  );
}