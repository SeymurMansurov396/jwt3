SELECT * FROM calls c left join 
applications a on c.id=a.call_id left join operators o
on c.operator_id=o.id;
