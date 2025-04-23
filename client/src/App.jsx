import { Route, Routes } from "react-router-dom";
import Menubar from "./component/Menubar/Menubar";
import Dashboard from "./pages/Dashboard/Dashboard";
import Explore from "./pages/Explore/Explore";
import ManageItem from "./pages/ManageItem/ManageItem";
import ManageCategory from "./pages/ManateCategory/ManageCategory";
import ManageUsers from "./pages/ManageUsers/ManageUsers";
import { Toaster } from "react-hot-toast";


const App = () => {
  return (
    <div>
      <Menubar />
      <Toaster/>
      <Routes>
        <Route path="/dashboard" element={<Dashboard />} />
        <Route path="/category" element={<ManageCategory />} />
        <Route path="/users" element={<ManageUsers />} />
        <Route path="/items" element={<ManageItem />} />
        <Route path="/explore" element={<Explore />} />
      </Routes>
    </div>
  );
};

export default App;
