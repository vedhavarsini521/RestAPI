import axios from "axios";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

export default function AddUser() {
  let navigate = useNavigate();

  const [user, setUser] = useState({
    itemName: "",
    brand: "",
    price: "",
    discount: "",
    rating: "",
  });

  const { itemName, brand, price, discount, rating } = user;

  const onInputChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.post("http://localhost:8080/user", user);
    navigate("/");
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Cart</h2>

          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="Item Name" className="form-label">
                Item Name
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter !!"
                name="itemName"
                value={itemName}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Brand" className="form-label">
                Brand
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter !!"
                name="brand"
                value={brand}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Price" className="form-label">
                Price
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter !!"
                name="price"
                value={price}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Discount" className="form-label">
                Discount
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter !!"
                name="discount"
                value={discount}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Rating" className="form-label">
                Rating
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter !!"
                name="rating"
                value={rating}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <button type="submit" className="btn btn-outline-primary" onSubmit={onSubmit}>
              Submit
            </button>
            <Link className="btn btn-outline-danger mx-2" to="/">
              Cancel
            </Link>
          </form>
        </div>
      </div>
    </div>
  );
}